package site.rhys.forum.system.gateway.manager;

import org.springframework.cloud.netflix.feign.FeignClient;
import site.rhys.forum.common.constant.ServiceNameConstants;
import site.rhys.forum.service.auth.api.api.AuthApi;
import site.rhys.forum.system.gateway.manager.fallback.AuthManagerFallback;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 21:17
 * @since 1.0.0
 */
@FeignClient(value = ServiceNameConstants.SERVICE_AUTH_NAME, fallback = AuthManagerFallback.class)
public interface AuthManager extends AuthApi {
}
