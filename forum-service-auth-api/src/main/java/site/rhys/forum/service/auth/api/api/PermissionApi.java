package site.rhys.forum.service.auth.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.auth.api.dto.PermissionDto;
import site.rhys.forum.service.auth.api.model.Permission;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 17:20
 * @since 1.0.0
 */
@Api(tags = "权限 api", description = "权限相关操作的api")
@RequestMapping("/permissions")
public interface PermissionApi {

    @ApiOperation(value = "查询所有权限")
    @GetMapping
    ResultVo<Page<Permission>> findAll(@PageableDefault Pageable pageable);

    @ApiOperation(value = "查询指定角色的权限")
    @GetMapping(params = "roleId")
    ResultVo<Page<Permission>> findAllByRoleId(@RequestParam("roleId") Long roleId,
                                               @PageableDefault Pageable pageable);


    @ApiOperation(value = "查询指定id权限")
    @GetMapping("/{id}")
    ResultVo<Permission> findById(@PathVariable("id") Long id);


    @ApiOperation(value = "添加权限，返回id")
    @PostMapping
    ResultVo<Permission> add(@RequestBody PermissionDto permissionDto);

    @ApiOperation(value = "更新用户非空字段")
    @PutMapping(value = "/{id}", params = "all=false")
    ResultVo<Permission> updateSelectionById(@PathVariable("id") Long id,
                                             @RequestBody PermissionDto permissionDto);


    @ApiOperation(value = "根据id删除权限")
    @DeleteMapping("/{id}")
    ResultVo<Void> deleteById(@PathVariable("id") Long id);

}
