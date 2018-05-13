package site.rhys.forum.service.user.controller;

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
public class UserController implements UserApi {
    @Autowired
    private UserService userService;

    @Override
    public User findById(Long id) {
        return userService.findById(id);
    }

    @Override
    public Page<User> findByPage(Pageable pageable) {
        return userService.findByPage(pageable);
    }

    @Override
    public void add(User user) {
        userService.add(user);
    }

    @Override
    public void updateById(Boolean selection, Long id, User user) {

    }
}
