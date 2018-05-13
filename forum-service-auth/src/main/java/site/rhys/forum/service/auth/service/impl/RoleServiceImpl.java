package site.rhys.forum.service.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rhys.forum.service.auth.api.model.Role;
import site.rhys.forum.service.auth.repository.RoleRepository;
import site.rhys.forum.service.auth.service.RoleService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:41
 * @since 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role selectById(Long id) {
        return roleRepository.findOne(id);
    }
}
