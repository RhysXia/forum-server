package site.rhys.forum.service.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.auth.api.api.UserRoleApi;
import site.rhys.forum.service.auth.api.dto.UserRoleDto;
import site.rhys.forum.service.auth.service.UserRoleService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 22:11
 * @since 1.0.0
 */
@RestController
public class UserRoleController implements UserRoleApi {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void updateByUserId(UserRoleDto userRoleDto) {
        userRoleService.updateByUserId(userRoleDto);
    }
}
