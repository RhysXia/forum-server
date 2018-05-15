package site.rhys.forum.service.auth.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.rhys.forum.service.auth.api.model.Permission;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:49
 * @since 1.0.0
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("select p from Permission p left join RolePermission rp on p.id = rp.roleId where rp.roleId = :roleId")
    Page<Permission> findAllByRoleId(@Param("roleId") Long roleId, Pageable pageable);

    Long countByIdIn(Long[] permissionIds);
}
