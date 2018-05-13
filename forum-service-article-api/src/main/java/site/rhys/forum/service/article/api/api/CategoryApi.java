package site.rhys.forum.service.article.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.article.api.model.Article;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "请求页", defaultValue = "0", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "size", value = "每页数据条数", defaultValue = "10", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "sort", value = "排序方式", example = "id,DESC", required = false, paramType = "query", dataType = "array"),
    })
    @GetMapping
    Page<Category> findByPage(@PageableDefault Pageable pageable);

    @ApiOperation(value = "分页查询分类下的文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类的id", required = true, paramType = "path", dataType = "long"),
            @ApiImplicitParam(name = "page", value = "请求页", defaultValue = "0", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "size", value = "每页数据条数", defaultValue = "10", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "sort", value = "排序方式", example = "id,DESC", required = false, paramType = "query", dataType = "array"),

    })
    @GetMapping("/{categoryId}/articles")
    Page<Article> findArticlesByPage(@PathVariable("categoryId") Long categoryId, @PageableDefault Pageable pageable);

    @ApiOperation(value = "根据文章id查找分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类的id", required = true, paramType = "path", dataType = "long")
    })
    @GetMapping("/{id}")
    Category findById(@PathVariable("id") Long id);

    @ApiOperation(value = "添加分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "分类名称", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "description", value = "分类描述", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "authorId", value = "作者id", required = true, paramType = "body", dataType = "long"),
    })
    @PostMapping
    void add(@RequestBody Category category);

    @ApiOperation(value = "修改分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类的id", required = true, paramType = "path", dataType = "long"),
            @ApiImplicitParam(name = "selection", value = "true：只修改传值不为空的字段，false：修改所有字段", required = false, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "分类名称", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "description", value = "分类描述", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "authorId", value = "作者id", required = true, paramType = "body", dataType = "long"),
    })
    @PutMapping("/{id}")
    void update(@RequestParam(value = "selection", required = false, defaultValue = "true") Boolean selection,
                @PathVariable("id") Long id,
                @RequestBody Category category);

    @ApiOperation(value = "删除分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类的id", required = true, paramType = "path", dataType = "long")
    })
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}
