package site.rhys.forum.service.article.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.article.api.dto.AddCategoryDto;
import site.rhys.forum.service.article.api.dto.UpdateCategoryDto;
import site.rhys.forum.service.article.api.model.Category;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:15
 * @since 1.0.0
 */
@Api(tags = "文章分类api", description = "文章分类相关操作的api")
@RequestMapping("/categories")
public interface CategoryApi {
    @ApiOperation(value = "分页查询分类")
    @GetMapping
    Page<Category> findAll(@PageableDefault Pageable pageable);

    @ApiOperation(value = "根据作者id查询分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true, paramType = "path", dataType = "long"),
    })
    @GetMapping
    Page<Category> findAllByAuthorId(@RequestParam("authorId") Long authorId,
                                     @PageableDefault Pageable pageable);


    @ApiOperation(value = "根据分类id查找分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类的id", required = true, paramType = "path", dataType = "long")
    })
    @GetMapping("/{id}")
    Category findById(@PathVariable("id") Long id);


    @ApiOperation(value = "添加分类,返回成功后的id")
    @PostMapping
    Long add(@RequestBody AddCategoryDto category);


    @ApiOperation(value = "修改分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类的id", required = true, paramType = "path", dataType = "long"),
    })
    @PutMapping(value = "/{id}", params = "all=false")
    void updateSelectionById(@PathVariable("id") Long id,
                             @RequestBody UpdateCategoryDto category);


    @ApiOperation(value = "删除分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类的id", required = true, paramType = "path", dataType = "long")
    })
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}
