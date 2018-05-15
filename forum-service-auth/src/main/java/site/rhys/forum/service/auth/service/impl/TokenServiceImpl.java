package site.rhys.forum.service.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.service.auth.api.dto.TokenDto;
import site.rhys.forum.service.auth.api.model.Token;
import site.rhys.forum.service.auth.manager.UserManager;
import site.rhys.forum.service.auth.repository.TokenRepository;
import site.rhys.forum.service.auth.service.TokenService;
import site.rhys.forum.service.user.api.model.User;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 23:24
 * @since 1.0.0
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserManager userManager;

    @Transactional
    @Override
    public Token signIn(TokenDto tokenDto) {
        if (tokenDto.getUsername() == null) {
            log.error("用户名不能为空");
            throw new IllegalArgumentException("用户名不能为空");
        }
        if (tokenDto.getPassword() == null) {
            log.error("密码不能为空");
            throw new IllegalArgumentException("密码不能为空");
        }

        User user = userManager.findByUsernameAndPassword(tokenDto.getUsername(), tokenDto.getPassword());

        if (user == null) {
            log.debug("用户名密码有误");
            throw new IllegalArgumentException("用户名密码有误");
        }

        //删除已经存在的token
        tokenRepository.deleteByUserId(user.getId());

        Token token = new Token();

        token.setUserId(user.getId());
        token.setCreateAt(new Date());
        token.setId(UUID.randomUUID().toString());
        tokenRepository.save(token);
        return token;
    }

    @Transactional
    @Override
    public void signOut(String token) {
        tokenRepository.delete(token);
    }
}
