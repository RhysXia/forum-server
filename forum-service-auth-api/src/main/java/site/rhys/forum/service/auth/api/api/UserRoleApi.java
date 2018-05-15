package site.rhys.forum.service.auth.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import site.rhys.forum.service.auth.api.dto.UserRoleDto;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 19:43
 * @since 1.0.0
 */
@Api(tags = "用户角色关系api", description = "用户角色关系相关操作的api")
@RequestMapping("/users")
public interface UserRoleApi {

    @ApiOperation("修改用户和角色的关系")
    @PutMapping
    void updateByUserId(
            @RequestBody UserRoleDto userRoleDto);
}
