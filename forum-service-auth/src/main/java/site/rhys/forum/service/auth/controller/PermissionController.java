package site.rhys.forum.service.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.vo.ResultVo;
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
    public ResultVo<Page<Permission>> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        Page<Permission> page = permissionService.findAll(pageable);
        return ResultVo.success("获取权限列表成功", page);
    }

    @Override
    public ResultVo<Page<Permission>> findAllByRoleId(Long roleId, Pageable pageable) {
        log.debug("findAllByRoleId: roleId-> {}, pageable-> {}", roleId, pageable);

        Page<Permission> page = permissionService.findAllByRoleId(roleId, pageable);
        return ResultVo.success("获取权限列表成功", page);
    }

    @Override
    public ResultVo<Permission> findById(Long id) {
        log.debug("findById: id-> {}", id);
        Permission permission = permissionService.findById(id);
        return ResultVo.success("获取权限成功", permission);
    }

    @Override
    public ResultVo<Permission> add(PermissionDto permissionDto) {
        log.debug("add: permissionDto-> {}", permissionDto);

        Permission permission = permissionService.add(permissionDto);
        return ResultVo.success("添加权限成功", permission);
    }

    @Override
    public ResultVo<Permission> updateSelectionById(Long id, PermissionDto permissionDto) {
        log.debug("updateSelectionById: id-> {}, permissionDto-> {}", id, permissionDto);

        Permission permission = permissionService.updateSelectionById(id, permissionDto);
        return ResultVo.success("更新权限成功", permission);
    }

    @Override
    public ResultVo<Void> deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);
        permissionService.deleteById(id);
        return ResultVo.success("删除权限成功", null);
    }
}
