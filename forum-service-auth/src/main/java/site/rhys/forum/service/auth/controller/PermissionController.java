package site.rhys.forum.service.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.auth.api.api.PermissionApi;
import site.rhys.forum.service.auth.api.dto.PermissionDto;
import site.rhys.forum.service.auth.api.model.Permission;
import site.rhys.forum.service.auth.service.PermissionService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 22:11
 * @since 1.0.0
 */
@RestController
@Slf4j
public class PermissionController implements PermissionApi {

    @Autowired
    private PermissionService permissionService;

    @Override
    public Page<Permission> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        return permissionService.findAll(pageable);
    }

    @Override
    public Page<Permission> findAllByRoleId(Long roleId, Pageable pageable) {
        log.debug("findAllByRoleId: roleId-> {}, pageable-> {}", roleId, pageable);

        return permissionService.findAllByRoleId(roleId, pageable);
    }

    @Override
    public Permission findById(Long id) {
        log.debug("findById: id-> {}", id);
        return permissionService.findById(id);
    }

    @Override
    public Long add(PermissionDto permissionDto) {
        log.debug("add: permissionDto-> {}", permissionDto);

        return permissionService.add(permissionDto);
    }

    @Override
    public void updateSelectionById(Long id, PermissionDto permissionDto) {
        log.debug("updateSelectionById: id-> {}, permissionDto-> {}", id, permissionDto);

        permissionService.updateSelectionById(id, permissionDto);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);

        permissionService.deleteById(id);
    }
}
