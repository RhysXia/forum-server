package site.rhys.forum.service.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
    public void add(User user) {
        user.setId(null);
        Date date = new Date();
        user.setCreateAt(date);
        userRepository.save(user);
    }
}
