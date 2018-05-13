package site.rhys.forum.service.auth.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import site.rhys.forum.service.auth.api.dto.LoginDto;
import site.rhys.forum.service.auth.api.model.Token;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 17:20
 * @since 1.0.0
 */
@Api(tags = "权限api", description = "权限相关操作的api")
@RequestMapping("/auth")
public interface AuthApi {

    @ApiOperation(value = "登录")
    @PostMapping
    Token login(@RequestBody LoginDto loginDto);

    @ApiOperation(value = "注销")
    @DeleteMapping
    void logout();
}
