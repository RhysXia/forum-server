package site.rhys.forum.service.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.NoExistEntityException;
import site.rhys.forum.service.user.api.model.User;
import site.rhys.forum.service.user.api.model.UserStatus;
import site.rhys.forum.service.user.repository.UserRepository;
import site.rhys.forum.service.user.service.UserService;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:41
 * @since 1.0.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Page<User> findByPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void updateSelectionById(Long id, User user) {
        User oldUser = userRepository.findOne(id);
        if (oldUser == null) {
            log.debug("id为{}的用户不存在,无法修改", id);
            throw new NoExistEntityException("id为" + id + "的用户不存在,无法修改");
        }
        String username = user.getUsername();
        if (username != null) {
            if (username.matches("^[0-9A-Za-z]{6,12}$")) {
                oldUser.setUsername(username);
            } else {
                log.debug("用户名长度在6-12之间(包含6和12),且只能包含数字和字母");
                throw new IllegalArgumentException("用户名长度在6-12之间(包含6和12),且只能包含数字和字母");
            }
        }
        String password = user.getPassword();
        if (password != null) {
            if (password.matches("^([0-9A-Za-z]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]{6,12})")) {
                oldUser.setPassword(password);
            } else {
                log.debug("密码长度在6-12之间(包含6和12),且只能包含数字和字母");
                throw new IllegalArgumentException("密码长度在6-12之间(包含6和12),且只能包含数字和字母");
            }
        }

        String nickname = user.getNickname();
        if (nickname != null) {
            if (nickname.matches("^.{1,20}$")) {
                oldUser.setNickname(nickname);
            } else {
                log.debug("昵称长度在1-20之间(包含1和20)");
                throw new IllegalArgumentException("昵称长度在1-20之间(包含1和20)");
            }
        }
        String info = user.getInfo();
        if (info != null) {
            oldUser.setInfo(info);
        }
        UserStatus status = user.getStatus();
        if (status != null) {
            oldUser.setStatus(status);
        }
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User add(User user) {
        // id置空
        user.setId(null);

        String username = user.getUsername();
        if (username == null || !username.matches("^[0-9A-Za-z]{6,12}$")) {
            log.debug("用户名长度在6-12之间(包含6和12),且只能包含数字和字母");
            throw new IllegalArgumentException("用户名长度在6-12之间(包含6和12),且只能包含数字和字母");
        }
        String password = user.getPassword();
        if (password == null || !password.matches("^([0-9A-Za-z]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]{6,12})")) {
            log.debug("密码长度在6-12之间(包含6和12),且只能包含数字和字母");
            throw new IllegalArgumentException("密码长度在6-12之间(包含6和12),且只能包含数字和字母");
        }

        String nickname = user.getNickname();
        if (nickname == null || !nickname.matches("^.{1,20}$")) {
            log.debug("昵称长度在1-20之间(包含1和20)");
            throw new IllegalArgumentException("昵称长度在1-20之间(包含1和20)");
        }


        UserStatus status = user.getStatus();
        if (status == null) {
            log.debug("用户状态不能为空");
            throw new IllegalArgumentException("用户状态不能为空");
        }
        user.setCreateAt(new Date());
        return userRepository.save(user);
    }
}
