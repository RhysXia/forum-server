package site.rhys.forum.service.article.manager.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import site.rhys.forum.service.article.manager.UserManager;
import site.rhys.forum.service.user.api.dto.UserDto;
import site.rhys.forum.service.user.api.model.User;

import java.util.Collections;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:35
 * @since 1.0.0
 */
@Component
@RequestMapping("/fallback/users")
@Slf4j
public class UserManagerFallback implements UserManager {

    @Override
    public User findById(Long id) {
        log.error("findById: id-> {}", id);
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        log.error("findById: pageable-> {}", pageable);
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public User findByUsername(String username) {
        log.error("findByUsername: username-> {}", username);
        return null;
    }

    @Override
    public Page<User> findAllByUsernameLike(String username, Pageable pageable) {
        log.error("findAllByUsernameLike: username-> {},pageable-> {}", username, pageable);
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public Page<User> findAllByNicknameLike(String nickname, Pageable pageable) {
        log.error("findAllByNicknameLike: nickname-> {},pageable-> {}", nickname, pageable);
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public Long add(UserDto user) {
        log.error("add: user-> {}", user);
        return null;
    }

    @Override
    public void updateSelectionById(Long id, UserDto user) {
        log.error("updateSelectionById: id-> {},user-> {}", id, user);
    }
}
