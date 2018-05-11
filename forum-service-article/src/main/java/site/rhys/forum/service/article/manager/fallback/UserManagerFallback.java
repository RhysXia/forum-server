package site.rhys.forum.service.article.manager.fallback;

import org.springframework.stereotype.Component;
import site.rhys.forum.service.user.api.api.UserApi;
import site.rhys.forum.service.user.api.model.User;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:35
 * @since 1.0.0
 */
@Component
public class UserManagerFallback implements UserApi {
    @Override
    public User findById(Long id) {
        System.out.println("111111111111111111111111111111111111111111111111111111111111111111");
        User user = new User();
        user.setUsername("请求失败");
        return user;
    }
}
