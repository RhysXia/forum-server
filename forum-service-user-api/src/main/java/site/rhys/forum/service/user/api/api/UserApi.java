package site.rhys.forum.service.user.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.rhys.forum.service.user.api.model.User;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:15
 * @since 1.0.0
 */
@Api(tags = "用户api", description = "用户相关操作的api")
public interface UserApi {

    @ApiOperation(value = "根据用户id查找用户")
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
