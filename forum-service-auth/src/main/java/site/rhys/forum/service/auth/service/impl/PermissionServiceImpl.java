package site.rhys.forum.service.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import site.rhys.forum.common.pojo.Permission;
import site.rhys.forum.service.auth.mapper.PermissionMapper;
import site.rhys.forum.service.auth.service.PermissionService;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 16:08
 */
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Permission findById(Long id) {
        log.info("根据id查找权限");
        return permissionMapper.selectById(id);
    }

    @Override
    @Transactional
    public void add(Permission permission) {
        log.info("添加权限");
        if (permission.getMethod() == null) {
            throw new IllegalArgumentException("method字段不能为空");
        }
        if (!StringUtils.hasText(permission.getUrl())) {
            throw new IllegalArgumentException("url字段不能为空或者空字符串");
        }
        if (!StringUtils.hasText(permission.getDescription())) {
            throw new IllegalArgumentException("description字段不能为空或者空字符串");
        }
        permissionMapper.add(permission);
    }
}
