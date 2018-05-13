package site.rhys.forum.service.user.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.user.api.model.User;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:15
 * @since 1.0.0
 */
@Api(tags = "用户api", description = "用户相关操作的api")
@RequestMapping("/users")
public interface UserApi {


    @ApiOperation(value = "根据用户id查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "请求的用户的id", required = true,dataType = "long")
    })
    @GetMapping("/{id}")
    User findById(@PathVariable("id") Long id);

    @ApiOperation(value = "分页查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "请求页", defaultValue = "0", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "size", value = "每页数据条数", defaultValue = "10", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "sort", value = "排序方式", example = "id,DESC", required = false, paramType = "query", dataType = "array"),
    })
    @GetMapping
    Page<User> findByPage(@PageableDefault Pageable pageable);

    @ApiOperation(value = "新建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "body"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "body"),
            @ApiImplicitParam(name = "nickname", value = "昵称", required = true, paramType = "body"),
            @ApiImplicitParam(name = "info", value = "简介", required = true, paramType = "body"),
            @ApiImplicitParam(name = "status", value = "用户状态", required = true, paramType = "body")
    })
    @PostMapping
    void add(@RequestBody User user);

    @ApiOperation(value = "修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "需要修改的用户id", required = true, paramType = "path"),
            @ApiImplicitParam(name = "selection", value = "true：只修改传值不为空的字段，false：修改所有字段", required = false, paramType = "query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = false, paramType = "body"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, paramType = "body"),
            @ApiImplicitParam(name = "nickname", value = "昵称", required = false, paramType = "body"),
            @ApiImplicitParam(name = "info", value = "简介", required = false, paramType = "body"),
            @ApiImplicitParam(name = "status", value = "用户状态", required = false, paramType = "body")

    })
    @PutMapping("/{id}")
    void updateById(@RequestParam(value = "selection", required = false, defaultValue = "true") Boolean selection, @PathVariable("id") Long id, @RequestBody User user);


}
