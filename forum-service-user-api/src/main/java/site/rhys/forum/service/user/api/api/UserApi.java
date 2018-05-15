package site.rhys.forum.service.user.api.api;

import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
            @ApiImplicitParam(name = "id", value = "请求的用户的id", required = true, dataType = "long")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    User findById(@PathVariable("id") Long id);

    @ApiOperation(value = "分页查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "请求页", defaultValue = "0", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "size", value = "每页数据条数", defaultValue = "10", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "sort", value = "排序方式", example = "id,DESC", required = false, paramType = "query", dataType = "array"),
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Page<User> findByPage(@PageableDefault Pageable pageable);

    @ApiOperation(value = "新建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", required = true),
            @ApiImplicitParam(name = "password", required = true),
            @ApiImplicitParam(name = "nickname", required = true),
            @ApiImplicitParam(name = "status", required = true),
            @ApiImplicitParam(name = "info", required = false),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "添加成功，返回用户id")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Long add(@RequestBody User user);

    @ApiOperation(value = "修改用户所有不为null的属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "需要修改的用户id", required = true, paramType = "path"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    void updateSelectionById(@PathVariable("id") Long id, @RequestBody User user);

}
