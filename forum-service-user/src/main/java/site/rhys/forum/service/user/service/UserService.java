package site.rhys.forum.service.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.rhys.forum.service.user.api.model.User;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:41
 * @since 1.0.0
 */
public interface UserService {
    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 分页查询用户
     *
     * @param pageable
     * @return
     */
    Page<User> findByPage(Pageable pageable);

    /**
     * 添加用户,返回添加完成的用户
     *
     * @param user
     */
    User add(User user);

    /**
     * 根据id更新非空字段
     *
     * @param id
     * @param user
     */
    void updateSelectionById(Long id, User user);
}
