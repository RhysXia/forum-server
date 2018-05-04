package site.rhys.forum.service.auth.service;

import site.rhys.forum.common.pojo.Permission;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 18:48
 */
public interface PermissionService {

    Permission findById(Long id);

    void add(Permission permission);
}
