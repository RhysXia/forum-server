package site.rhys.forum.service.auth.service;

import site.rhys.forum.service.auth.api.dto.UserRoleDto;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 23:10
 * @since 1.0.0
 */
public interface UserRoleService {
    void updateByUserId(UserRoleDto userRoleDto);
}
