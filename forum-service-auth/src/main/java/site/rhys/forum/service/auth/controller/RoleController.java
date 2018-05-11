package site.rhys.forum.service.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.auth.api.api.RoleApi;
import site.rhys.forum.service.auth.api.model.Role;
import site.rhys.forum.service.auth.service.RoleService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:21
 * @since 1.0.0
 */
@RestController
public class RoleController implements RoleApi {
    @Autowired
    private RoleService roleService;

    @Override
    public Role findById(Long id) {
        return roleService.selectById(id);
    }
}
