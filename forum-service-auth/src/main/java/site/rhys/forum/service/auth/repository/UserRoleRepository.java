package site.rhys.forum.service.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.rhys.forum.service.auth.api.model.UserRole;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:49
 * @since 1.0.0
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
