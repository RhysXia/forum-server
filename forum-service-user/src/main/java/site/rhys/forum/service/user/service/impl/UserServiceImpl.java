package site.rhys.forum.service.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.common.utils.SecurityUtils;
import site.rhys.forum.service.user.api.dto.UserDto;
import site.rhys.forum.service.user.api.model.User;
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

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Page<User> findAllByUsernameLike(String username, Pageable pageable) {
        return userRepository.findAllByUsernameLike(username, pageable);
    }

    @Override
    public Page<User> findAllByNicknameLike(String nickname, Pageable pageable) {
        return userRepository.findByNicknameLike(nickname, pageable);
    }

    @Transactional
    @Override
    public User updateSelectionById(Long id, UserDto user) {
        User oldUser = userRepository.findOne(id);
        if (oldUser == null) {
            log.error("id为{}的用户不存在", id);
            throw new IllegalArgumentException("id为" + id + "的用户不存在");
        }
        if (user.getUsername() != null) {
            oldUser.setUsername(user.getUsername());
        }
        if (user.getNickname() != null) {
            oldUser.setNickname(user.getNickname());
        }
        if (user.getInfo() != null) {
            oldUser.setInfo(user.getInfo());
        }
        if (user.getStatus() != null) {
            oldUser.setStatus(user.getStatus());
        }
        if (user.getGender() != null) {
            oldUser.setGender(user.getGender());
        }
        if (user.getEmail() != null) {
            if (user.getEmail().matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$")) {
                oldUser.setEmail(user.getEmail());
            } else {
                log.error("email格式不正确");
                throw new IllegalArgumentException("email格式不正确");
            }
        }
        if (user.getPassword() != null) {
            String encryptPassword = SecurityUtils.encrypt(user.getPassword());
            oldUser.setPassword(encryptPassword);
        }
        return userRepository.save(oldUser);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        if (username == null || password == null) {
            log.error("用户名密码不能为空");
            throw new IllegalArgumentException("用户名密码不能为空");
        }
        return userRepository.findByUsernameAndPassword(username, SecurityUtils.encrypt(password));
    }


    @Transactional
    @Override
    public User add(UserDto user) {

        User newUser = new User();

        if (user.getUsername() == null) {
            log.error("用户名不能为空");
            throw new IllegalArgumentException("用户名不能为空");
        }
        if (user.getNickname() == null) {
            log.error("昵称不能为空");
            throw new IllegalArgumentException("昵称不能为空");
        }
        if (user.getInfo() == null) {
            log.error("简介不能为空");
            throw new IllegalArgumentException("简介不能为空");
        }
        if (user.getStatus() == null) {
            log.error("状态不能为空");
            throw new IllegalArgumentException("状态不能为空");
        }
        if (user.getPassword() == null) {
            log.error("密码不能为空");
            throw new IllegalArgumentException("密码不能为空");
        }
        if (user.getGender() == null) {
            log.error("性别不能为空");
            throw new IllegalArgumentException("性别不能为空");
        }

        if (user.getEmail() != null && !user.getEmail().matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$")) {
            log.error("email格式不正确");
            throw new IllegalArgumentException("email格式不正确");
        }

        BeanUtils.copyProperties(user, newUser);
        String encryptPassword = SecurityUtils.encrypt(user.getPassword());
        newUser.setPassword(encryptPassword);

        newUser.setCreateAt(new Date());

        return userRepository.save(newUser);
    }
}
