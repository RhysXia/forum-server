package site.rhys.forum.service.auth.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.rhys.forum.service.auth.api.dto.PermissionDto;
import site.rhys.forum.service.auth.api.model.Permission;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 22:17
 * @since 1.0.0
 */
public interface PermissionService {
    Page<Permission> findAll(Pageable pageable);

    Page<Permission> findAllByRoleId(Long roleId, Pageable pageable);

    Permission findById(Long id);

    Permission add(PermissionDto permissionDto);

    Permission updateSelectionById(Long id, PermissionDto permissionDto);

    void deleteById(Long id);
}
