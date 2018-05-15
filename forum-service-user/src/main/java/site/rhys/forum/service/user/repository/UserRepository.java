package site.rhys.forum.service.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import site.rhys.forum.service.user.api.model.User;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:49
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Page<User> findAllByUsernameLike(String username, Pageable pageable);

    Page<User> findByNicknameLike(String nickname, Pageable pageable);

    User findByUsernameAndPassword(String username, String encrypt);
}
