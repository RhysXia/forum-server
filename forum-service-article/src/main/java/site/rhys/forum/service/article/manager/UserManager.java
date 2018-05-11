package site.rhys.forum.service.article.manager;

import org.springframework.cloud.netflix.feign.FeignClient;
import site.rhys.forum.common.constant.ServiceNameConstants;
import site.rhys.forum.service.article.manager.fallback.UserManagerFallback;
import site.rhys.forum.service.user.api.api.UserApi;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:31
 * @since 1.0.0
 */
@FeignClient(value = ServiceNameConstants.SERVICE_USER_NAME, fallback = UserManagerFallback.class)
public interface UserManager extends UserApi {
}
