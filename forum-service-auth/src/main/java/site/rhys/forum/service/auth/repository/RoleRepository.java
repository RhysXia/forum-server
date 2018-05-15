package site.rhys.forum.service.auth.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.rhys.forum.service.auth.api.model.Role;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:49
 * @since 1.0.0
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r left join UserRole ur on r.id = ur.roleId where ur.userId = :userId")
    Page<Role> findAllByUserId(@Param("userId") Long userId, Pageable pageable);
}
