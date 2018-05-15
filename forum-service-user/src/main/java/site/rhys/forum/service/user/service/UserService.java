package site.rhys.forum.service.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.rhys.forum.service.user.api.dto.UserDto;
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
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据用户名模糊查找用户
     *
     * @param username
     * @return
     */
    Page<User> findAllByUsernameLike(String username, Pageable pageable);


    /**
     * 根据昵称模糊查找用户
     *
     * @param nickname
     * @return
     */
    Page<User> findAllByNicknameLike(String nickname, Pageable pageable);

    /**
     * 添加用户,返回添加完成的用户
     *
     * @param user
     * @return 用户id
     */
    Long add(UserDto user);

    /**
     * 根据id更新非空字段
     *
     * @param id
     * @param user
     */
    void updateSelectionById(Long id, UserDto user);

    User findByUsernameAndPassword(String username, String password);
}
