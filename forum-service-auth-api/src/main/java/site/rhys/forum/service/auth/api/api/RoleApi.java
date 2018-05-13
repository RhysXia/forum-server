package site.rhys.forum.service.auth.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.rhys.forum.service.auth.api.model.Role;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:15
 * @since 1.0.0
 */
@Api(tags = "角色api", description = "用户角色相关操作的api")
@RequestMapping("/roles")
public interface RoleApi {

    @ApiOperation(value = "根据角色id查找文章")
    @GetMapping("/{id}")
    Role findById(@PathVariable("id") Long id);
}
