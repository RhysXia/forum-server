package site.rhys.forum.service.auth.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.rhys.forum.service.auth.api.model.Role;

import java.util.List;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:49
 * @since 1.0.0
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Page<Role> findAllByIdIn(List<Long> roleIds, Pageable pageable);
}
