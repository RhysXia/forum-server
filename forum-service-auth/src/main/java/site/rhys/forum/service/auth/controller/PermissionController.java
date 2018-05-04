package site.rhys.forum.service.auth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.common.pojo.Permission;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.auth.service.PermissionService;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 19:07
 */
@Api(tags = "权限api", description = "权限相关的api")
@ApiResponses({
        @ApiResponse(code = 200, message = "请求得到响应")
})
@RestController
@RequestMapping("/permissions")
@Slf4j
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "根据权限id查找权限")
    @GetMapping("/{id:\\d+}")
    public ResultVo findById(@PathVariable("id") Long id) {
        log.info("根据权限id查找权限");
        Permission permission = permissionService.findById(id);
        if (permission == null) {
            return ResultVo.fail("指定id的权限不存在");
        }
        return ResultVo.success("获取权限成功", permission);
    }

    @ApiOperation(value = "添加权限")
    @PostMapping
    public ResultVo add(@RequestBody Permission permission) {
        log.info("添加权限");
        permissionService.add(permission);
        return ResultVo.success("添加成功");
    }
}
