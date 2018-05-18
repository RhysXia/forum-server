package site.rhys.forum.service.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.service.auth.api.dto.PermissionDto;
import site.rhys.forum.service.auth.api.model.Permission;
import site.rhys.forum.service.auth.api.model.RolePermission;
import site.rhys.forum.service.auth.repository.PermissionRepository;
import site.rhys.forum.service.auth.repository.RolePermissionRepository;
import site.rhys.forum.service.auth.repository.RoleRepository;
import site.rhys.forum.service.auth.service.PermissionService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 22:17
 * @since 1.0.0
 */
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public Page<Permission> findAll(Pageable pageable) {
        return permissionRepository.findAll(pageable);
    }

    @Override
    public Page<Permission> findAllByRoleId(Long roleId, Pageable pageable) {
        List<RolePermission> rolePermissionList = rolePermissionRepository.findAllByRoleId(roleId);
        List<Long> permissionIds = rolePermissionList.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        return permissionRepository.findAllByIdIn(permissionIds, pageable);
    }

    @Override
    public Permission findById(Long id) {
        return permissionRepository.findOne(id);
    }

    @Transactional
    @Override
    public Long add(PermissionDto permissionDto) {
        if (permissionDto.getUrl() == null) {
            log.error("url不能为空");
            throw new IllegalArgumentException("url不能为空");
        }
        if (permissionDto.getMethod() == null) {
            log.error("method不能为空");
            throw new IllegalArgumentException("method不能为空");
        }
        Permission permission = new Permission();
        BeanUtils.copyProperties(permissionDto, permission);
        permission.setCreateAt(new Date());
        return permissionRepository.save(permission).getId();
    }

    @Transactional
    @Override
    public void updateSelectionById(Long id, PermissionDto permissionDto) {
        Permission permission = permissionRepository.findOne(id);
        if (permission == null) {
            log.error("权限不存在");
            throw new IllegalArgumentException("权限不存在");
        }
        if (permissionDto.getMethod() != null) {
            permission.setMethod(permissionDto.getMethod());
        }
        if (permissionDto.getUrl() != null) {
            permission.setUrl(permissionDto.getUrl());
        }
        permissionRepository.save(permission);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Permission permission = permissionRepository.findOne(id);
        if (permission == null) {
            log.error("权限不存在");
            throw new IllegalArgumentException("权限不存在");
        }
        //判断是否有角色使用

        Long count = rolePermissionRepository.countByPermissionId(id);
        if(count>0){
            log.error("权限正在使用,无法删除");
            throw new IllegalArgumentException("权限正在使用,无法删除");
        }

        permissionRepository.delete(permission);
    }
}
