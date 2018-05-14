package site.rhys.forum.service.article.manager.fallback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import site.rhys.forum.service.article.manager.UserManager;
import site.rhys.forum.service.user.api.model.User;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:35
 * @since 1.0.0
 */
@Component
@RequestMapping
public class UserManagerFallback implements UserManager{

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public Page<User> findByPage(Pageable pageable) {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void updateById(Boolean selection, Long id, User user) {

    }
}
