package site.rhys.forum.service.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.auth.api.api.RoleApi;
import site.rhys.forum.service.auth.api.dto.RoleDto;
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
    public ResultVo<Page<Role>> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        Page<Role> page = roleService.findAll(pageable);
        return ResultVo.success("获取角色列表成功", page);
    }

    @Override
    public ResultVo<Page<Role>> findAllByUserId(Long userId, Pageable pageable) {
        log.debug("findAllByUserId: userId-> {}, pageable-> {}", userId, pageable);
        Page<Role> page = roleService.findAllByUserId(userId, pageable);
        return ResultVo.success("获取角色列表成功", page);
    }

    @Override
    public ResultVo<Role> findById(Long id) {
        log.debug("findById: id-> {}", id);
        Role role = roleService.findById(id);
        return ResultVo.success("获取角色成功", role);
    }

    @Override
    public ResultVo<Role> add(RoleDto roleDto) {
        log.debug("add: roleDto-> {}", roleDto);
        Role role = roleService.add(roleDto);
        return ResultVo.success("添加角色成功", role);
    }

    @Override
    public ResultVo<Role> updateSelectionById(Long id, RoleDto roleDto) {
        log.debug("updateSelectionById: id-> {}, roleDto-> {}", id, roleDto);
        Role role = roleService.updateSelectionById(id, roleDto);
        return ResultVo.success("更新角色成功", role);
    }

    @Override
    public ResultVo<Void> deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);
        roleService.deleteById(id);
        return ResultVo.success("删除角色成功", null);
    }
}
