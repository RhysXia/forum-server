package site.rhys.forum.service.auth.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.auth.api.dto.TokenDto;
import site.rhys.forum.service.auth.api.model.Token;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 17:20
 * @since 1.0.0
 */
@Api(tags = "token api", description = "token相关操作的api")
@RequestMapping("/tokens")
public interface TokenApi {

    @ApiOperation(value = "创建token，登录")
    @PostMapping
    Token signIn(@RequestBody TokenDto tokenDto);


    @ApiOperation(value = "删除token，注销")
    @DeleteMapping("/{token}")
    void signOut(@PathVariable("token") String token);

}
