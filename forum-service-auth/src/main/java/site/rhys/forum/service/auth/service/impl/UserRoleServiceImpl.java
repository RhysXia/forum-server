package site.rhys.forum.service.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.service.auth.api.dto.UserRoleDto;
import site.rhys.forum.service.auth.api.model.UserRole;
import site.rhys.forum.service.auth.manager.UserManager;
import site.rhys.forum.service.auth.repository.UserRoleRepository;
import site.rhys.forum.service.auth.service.UserRoleService;
import site.rhys.forum.service.user.api.model.User;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 23:10
 * @since 1.0.0
 */
@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserManager userManager;

    @Transactional
    @Override
    public List<UserRole> updateByUserId(UserRoleDto userRoleDto) {
        if (userRoleDto.getUserId() == null) {
            log.error("用户id不能为空");
            throw new IllegalArgumentException("用户id不能为空");
        }
        if (userRoleDto.getRoleIds() == null || userRoleDto.getRoleIds().length == 0) {
            log.error("角色id数组不能为空");
            throw new IllegalArgumentException("角色id数组不能为空");
        }

        User user = userManager.findById(userRoleDto.getUserId()).getData();
        if (user == null) {
            log.error("用户不存在");
            throw new IllegalArgumentException("用户不存在");
        }

        userRoleRepository.deleteByUserId(userRoleDto.getUserId());

        List<UserRole> userRoleList = new LinkedList<>();
        for (Long roleId : userRoleDto.getRoleIds()) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userRoleDto.getUserId());
            userRole.setRoleId(roleId);
            userRoleList.add(userRole);
        }
        return userRoleRepository.save(userRoleList);
    }
}
