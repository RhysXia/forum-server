package site.rhys.forum.service.user.api.api;

import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.user.api.dto.UserDto;
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
    User findById(@PathVariable("id") Long id);


    @ApiOperation(value = "分页查找用户")
    @GetMapping
    Page<User> findAll(@PageableDefault Pageable pageable);


    @ApiOperation("根据用户名精确查找指定用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string")
    })
    @GetMapping
    User findByUsername(@RequestParam("username") String username);


    @ApiOperation("根据用户名模糊查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string")
    })
    @GetMapping("/search")
    Page<User> findAllByUsernameLike(@RequestParam("username") String username,
                                     @PageableDefault Pageable pageable);


    @ApiOperation("根据昵称模糊查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickname", value = "昵称", required = true, dataType = "string")
    })
    @GetMapping("/search")
    Page<User> findAllByNicknameLike(@RequestParam("nickname") String nickname,
                                     @PageableDefault Pageable pageable);


    @ApiOperation(value = "新建用户")
    @PostMapping
    Long add(@RequestBody UserDto user);


    @ApiOperation(value = "修改用户所有不为null的属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "需要修改的用户id", required = true, paramType = "path"),
    })
    @PutMapping(value = "/{id}", params = "all=false")
    void updateSelectionById(@PathVariable("id") Long id, @RequestBody UserDto user);


}
