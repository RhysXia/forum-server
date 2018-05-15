package site.rhys.forum.service.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.user.api.api.UserApi;
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
        log.debug("findById: {}", id);
        return userService.findById(id);
    }

    @Override
    public Page<User> findByPage(Pageable pageable) {
        log.debug("findByPage: {}", pageable);
        return userService.findByPage(pageable);
    }

    @Override
    public Long add(User user) {
        log.debug("add: {}", user);
        User newUser = userService.add(user);
        return newUser.getId();
    }

    @Override
    public void updateSelectionById(Long id, User user) {
        log.debug("updateSelectionById: id-> {},user-> {}", id, user);
        userService.updateSelectionById(id, user);
    }
}
