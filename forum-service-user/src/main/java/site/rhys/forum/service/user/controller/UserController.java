package site.rhys.forum.service.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.user.api.api.UserApi;
import site.rhys.forum.service.user.api.dto.UserDto;
import site.rhys.forum.service.user.api.model.User;
import site.rhys.forum.service.user.service.UserService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:21
 * @since 1.0.0
 */
@RestController
@Slf4j
public class UserController implements UserApi {
    @Autowired
    private UserService userService;


    @Override
    public User findById(Long id) {
        log.debug("findById: id-> {}", id);
        return userService.findById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        return userService.findByPage(pageable);
    }

    @Override
    public User findByUsername(String username) {
        log.debug("findByUsername: username-> {}", username);
        return userService.findByUsername(username);
    }

    @Override
    public Page<User> findAllByUsernameLike(String username, Pageable pageable) {
        log.debug("findAllByUsernameLike: username-> {},pageable-> {}", username, pageable);
        return userService.findAllByUsernameLike(username, pageable);
    }

    @Override
    public Page<User> findAllByNicknameLike(String nickname, Pageable pageable) {
        log.debug("findAllByUsernameLike: nickname-> {},pageable-> {}", nickname, pageable);
        return userService.findAllByNicknameLike(nickname, pageable);
    }

    @Override
    public Long add(UserDto user) {
        log.debug("add: user-> {}", user);
        return userService.add(user);
    }

    @Override
    public void updateSelectionById(Long id, UserDto user) {
        log.debug("updateSelectionById: id-> {},user-> {}", id, user);
        userService.updateSelectionById(id, user);
    }

}
