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
import site.rhys.forum.service.article.api.model.Comment;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:15
 * @since 1.0.0
 */
@Api(tags = "文章api", description = "文章相关操作的api")
@RequestMapping("/articles")
public interface ArticleApi {


    @ApiOperation(value = "分页查询文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "请求页", defaultValue = "0", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "size", value = "每页数据条数", defaultValue = "10", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "sort", value = "排序方式", example = "id,DESC", required = false, paramType = "query", dataType = "array"),
    })
    @GetMapping
    Page<Article> findByPage(@PageableDefault Pageable pageable);

    @ApiOperation(value = "分页查询文章下的评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true, paramType = "path", dataType = "long"),
            @ApiImplicitParam(name = "page", value = "请求页", defaultValue = "0", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "size", value = "每页数据条数", defaultValue = "10", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "sort", value = "排序方式", example = "id,DESC", required = false, paramType = "query", dataType = "array"),
    })
    @GetMapping("/{articleId}/comments")
    Page<Comment> findArticlesByPage(@PathVariable("articleId") Long articleIds, @PageableDefault Pageable pageable);


    @ApiOperation(value = "根据文章id查找文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章的id", required = true, paramType = "path", dataType = "long")
    })
    @GetMapping("/{id}")
    Article findById(@PathVariable("id") Long id);

    @ApiOperation(value = "添加文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "contextType", value = "文章内容类型", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "authorId", value = "作者id", required = true, paramType = "body", dataType = "long"),
            @ApiImplicitParam(name = "categoryId", value = "分类id", required = true, paramType = "body", dataType = "long")
    })
    @PostMapping
    void add(@RequestBody Article article);

    @ApiOperation(value = "修改文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章的id", required = true, paramType = "path", dataType = "long"),
            @ApiImplicitParam(name = "selection", value = "true：只修改传值不为空的字段，false：修改所有字段", required = false, paramType = "query"),
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "contextType", value = "文章内容类型", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "categoryId", value = "分类id", required = true, paramType = "body", dataType = "long")
    })
    @PutMapping("/{id}")
    void update(@RequestParam(value = "selection", required = false, defaultValue = "true") Boolean selection,
                @PathVariable("id") Long id,
                @RequestBody Article article);

    @ApiOperation(value = "删除文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章的id", required = true, paramType = "path", dataType = "long")
    })
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}
