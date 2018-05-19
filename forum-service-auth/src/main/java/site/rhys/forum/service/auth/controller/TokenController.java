package site.rhys.forum.service.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.auth.api.api.TokenApi;
import site.rhys.forum.service.auth.api.dto.TokenDto;
import site.rhys.forum.service.auth.api.model.Token;
import site.rhys.forum.service.auth.service.TokenService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 22:11
 * @since 1.0.0
 */
@RestController
@Slf4j
public class TokenController implements TokenApi {

    @Autowired
    private TokenService tokenService;

    @Override
    public ResultVo<Token> signIn(TokenDto tokenDto) {
        log.debug("signIn: tokenDto-> {}", tokenDto);
        Token token = tokenService.signIn(tokenDto);
        return ResultVo.success("获取token成功", token);
    }

    @Override
    public ResultVo<Void> signOut(String token) {
        log.debug("signOut: token-> {}", token);
        tokenService.signOut(token);
        return ResultVo.success("注销成功", null);
    }
}
