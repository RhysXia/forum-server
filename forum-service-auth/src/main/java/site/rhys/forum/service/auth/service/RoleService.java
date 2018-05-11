package site.rhys.forum.service.auth.service;

import site.rhys.forum.service.auth.api.model.Role;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:41
 * @since 1.0.0
 */
public interface RoleService {
    Role selectById(Long id);
}
