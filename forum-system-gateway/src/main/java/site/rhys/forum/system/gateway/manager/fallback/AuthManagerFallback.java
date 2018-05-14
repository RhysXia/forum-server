package site.rhys.forum.system.gateway.manager.fallback;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import site.rhys.forum.service.auth.api.dto.PermissionDto;
import site.rhys.forum.system.gateway.manager.AuthManager;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 21:18
 * @since 1.0.0
 */
@Component
@RequestMapping
public class AuthManagerFallback implements AuthManager {

    @Override
    public Boolean isPermitted(PermissionDto permissionDto) {
        return false;
    }
}
