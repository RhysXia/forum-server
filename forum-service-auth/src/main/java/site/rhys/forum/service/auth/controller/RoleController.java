package site.rhys.forum.service.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.auth.api.api.RoleApi;
import site.rhys.forum.service.auth.api.dto.RoleDto;
import site.rhys.forum.service.auth.api.model.Permission;
import site.rhys.forum.service.auth.api.model.Role;
import site.rhys.forum.service.auth.service.RoleService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 22:11
 * @since 1.0.0
 */
@RestController
@Slf4j
public class RoleController implements RoleApi {

    @Autowired
    private RoleService roleService;

    @Override
    public Page<Role> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        return roleService.findAll(pageable);
    }

    @Override
    public Page<Role> findAllByUserId(Long userId, Pageable pageable) {
        log.debug("findAllByUserId: userId-> {}, pageable-> {}", userId, pageable);
        return roleService.findAllByUserId(userId, pageable);
    }

    @Override
    public Role findById(Long id) {
        log.debug("findById: id-> {}", id);
        return roleService.findById(id);
    }

    @Override
    public Long add(RoleDto roleDto) {
        log.debug("add: roleDto-> {}", roleDto);
        return roleService.add(roleDto);
    }

    @Override
    public void updateSelectionById(Long id, RoleDto roleDto) {
        log.debug("updateSelectionById: id-> {}, roleDto-> {}", id, roleDto);

        roleService.updateSelectionById(id, roleDto);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);

        roleService.deleteById(id);
    }
}
