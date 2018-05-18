package site.rhys.forum.service.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.vo.ResultVo;
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
    public ResultVo<User> findById(Long id) {
        log.debug("findById: id-> {}", id);
        User user = userService.findById(id);
        return ResultVo.success("获取用户信息成功", user);
    }

    @Override
    public ResultVo<Page<User>> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        Page<User> page = userService.findByPage(pageable);
        return ResultVo.success("获取用户列表成功", page);
    }

    @Override
    public ResultVo<User> findByUsername(String username) {
        log.debug("findByUsername: username-> {}", username);
        User user = userService.findByUsername(username);
        return ResultVo.success("获取用户成功", user);
    }

    @Override
    public ResultVo<User> findByUsernameAndPassword(String username, String password) {
        User user = userService.findByUsernameAndPassword(username, password);
        return ResultVo.success("获取用户成功", user);
    }

    @Override
    public ResultVo<Page<User>> findAllByUsernameLike(String username, Pageable pageable) {
        log.debug("findAllByUsernameLike: username-> {},pageable-> {}", username, pageable);
        Page<User> page = userService.findAllByUsernameLike(username, pageable);
        return ResultVo.success("获取用户列表成功", page);
    }

    @Override
    public ResultVo<Page<User>> findAllByNicknameLike(String nickname, Pageable pageable) {
        log.debug("findAllByUsernameLike: nickname-> {},pageable-> {}", nickname, pageable);
        Page<User> page = userService.findAllByNicknameLike(nickname, pageable);
        return ResultVo.success("获取用户列表成功", page);
    }

    @Override
    public ResultVo<User> add(UserDto user) {
        log.debug("add: user-> {}", user);
        User res = userService.add(user);
        return ResultVo.success("添加用户成功", res);
    }

    @Override
    public ResultVo<User> updateSelectionById(Long id, UserDto user) {
        log.debug("updateSelectionById: id-> {},user-> {}", id, user);
        User res = userService.updateSelectionById(id, user);
        return ResultVo.success("更新用户成功", res);
    }

}
