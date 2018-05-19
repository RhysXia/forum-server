package site.rhys.forum.service.auth.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.rhys.forum.service.auth.api.dto.RoleDto;
import site.rhys.forum.service.auth.api.model.Role;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:41
 * @since 1.0.0
 */
public interface RoleService {
    Page<Role> findAll(Pageable pageable);

    Page<Role> findAllByUserId(Long userId, Pageable pageable);

    Role findById(Long id);

    Role add(RoleDto roleDto);

    Role updateSelectionById(Long id, RoleDto roleDto);

    void deleteById(Long id);
}
