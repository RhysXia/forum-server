package site.rhys.forum.service.auth.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.auth.api.dto.RoleDto;
import site.rhys.forum.service.auth.api.model.Permission;
import site.rhys.forum.service.auth.api.model.Role;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 17:20
 * @since 1.0.0
 */
@Api(tags = "角色 api", description = "角色相关操作的api")
@RequestMapping("/roles")
public interface RoleApi {

    @ApiOperation(value = "查询所有角色")
    @GetMapping
    Page<Role> findAll(@PageableDefault Pageable pageable);

    @ApiOperation(value = "查询指定用户的角色")
    @GetMapping(params = "userId")
    Page<Role> findAllByUserId(@RequestParam("userId") Long userId,
                                     @PageableDefault Pageable pageable);


    @ApiOperation(value = "查询指定id角色")
    @GetMapping("/{id}")
    Role findById(@PathVariable("id") Long id);


    @ApiOperation(value = "添加角色，返回id")
    @PostMapping
    Long add(@RequestBody RoleDto roleDto);

    @ApiOperation(value = "更新角色非空字段")
    @PutMapping(value = "/{id}", params = "all=false")
    void updateSelectionById(@PathVariable("id") Long id,
                             @RequestBody RoleDto roleDto);


    @ApiOperation(value = "根据id删除角色")
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);

}
