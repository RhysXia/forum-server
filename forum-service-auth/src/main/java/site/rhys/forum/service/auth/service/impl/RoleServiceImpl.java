package site.rhys.forum.service.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.service.auth.api.dto.RoleDto;
import site.rhys.forum.service.auth.api.model.Role;
import site.rhys.forum.service.auth.api.model.RolePermission;
import site.rhys.forum.service.auth.repository.PermissionRepository;
import site.rhys.forum.service.auth.repository.RolePermissionRepository;
import site.rhys.forum.service.auth.repository.RoleRepository;
import site.rhys.forum.service.auth.repository.UserRoleRepository;
import site.rhys.forum.service.auth.service.RoleService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:41
 * @since 1.0.0
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Page<Role> findAllByUserId(Long userId, Pageable pageable) {
        return roleRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findOne(id);
    }

    @Transactional
    @Override
    public Long add(RoleDto roleDto) {
        if (roleDto.getName() == null) {
            log.error("名称不能为空");
            throw new IllegalArgumentException("名称不能为空");
        }
        if (roleDto.getDescription() == null) {
            log.error("描述不能为空");
            throw new IllegalArgumentException("描述不能为空");
        }

        if (roleDto.getPermissionIds() != null) {
            Long count = permissionRepository.countByIdIn(roleDto.getPermissionIds());
            if (count != roleDto.getPermissionIds().length) {
                log.error("权限id数组中有不存在的权限");
                throw new IllegalArgumentException("权限id数组中有不存在的权限");
            }
        }

        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        Date date = new Date();
        role.setCreateAt(date);
        role.setUpdateAt(date);
        Role newRole = roleRepository.save(role);


        if (roleDto.getPermissionIds() != null) {
            List<RolePermission> rolePermissionList = new LinkedList<>();

            for (Long permissionId : roleDto.getPermissionIds()) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setPermissionId(permissionId);
                rolePermission.setRoleId(newRole.getId());
                rolePermissionList.add(rolePermission);
            }
            rolePermissionRepository.save(rolePermissionList);

        }

        return newRole.getId();
    }

    @Transactional
    @Override
    public void updateSelectionById(Long id, RoleDto roleDto) {
        Role role = roleRepository.findOne(id);
        if (role == null) {
            log.error("角色不存在");
            throw new IllegalArgumentException("角色不存在");
        }

        if (roleDto.getName() != null) {
            role.setName(roleDto.getName());
        }
        if (roleDto.getDescription() != null) {
            role.setDescription(roleDto.getDescription());
        }
        if (roleDto.getPermissionIds() != null) {
            //删除原来的关系，添加新的关系
            rolePermissionRepository.deleteByRoleId(id);
            List<RolePermission> rolePermissionList = new LinkedList<>();

            for (Long permissionId : roleDto.getPermissionIds()) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setPermissionId(permissionId);
                rolePermission.setRoleId(id);
                rolePermissionList.add(rolePermission);
            }
            rolePermissionRepository.save(rolePermissionList);
        }

        roleRepository.save(role);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Role role = roleRepository.findOne(id);
        if (role == null) {
            log.error("角色不存在");
            throw new IllegalArgumentException("角色不存在");
        }
        // 判断是否存在用户占有该权限
        Long count = userRoleRepository.countByRoleId(id);
        if (count > 0) {
            log.error("有用户占有该权限,无法删除");
            throw new IllegalArgumentException("有用户占有该权限,无法删除");
        }

        rolePermissionRepository.deleteByRoleId(id);
        roleRepository.delete(id);
    }
}
