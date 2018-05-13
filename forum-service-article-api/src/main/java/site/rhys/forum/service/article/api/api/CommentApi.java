package site.rhys.forum.service.article.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.article.api.model.Comment;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:15
 * @since 1.0.0
 */
@Api(tags = "评论api", description = "评论相关操作的api")
@RequestMapping("/comments")
public interface CommentApi {

    @ApiOperation(value = "根据评论id查找评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "评论的id", required = true, paramType = "path", dataType = "long")
    })
    @GetMapping("/{id}")
    Comment findById(@PathVariable("id") Long id);

    @ApiOperation(value = "根据父评论id查询评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父分类的id", required = true, paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "page", value = "请求页", defaultValue = "0", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "size", value = "每页数据条数", defaultValue = "10", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "sort", value = "排序方式", example = "id,DESC", required = false, paramType = "query", dataType = "array"),

    })
    @GetMapping
    Page<Comment> findChildrenById(@RequestParam("parentId") Long parentId, @PageableDefault Pageable pageable);

    @ApiOperation(value = "添加评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content", value = "评论内容", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "contextType", value = "文章内容类型", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "authorId", value = "作者id", required = true, paramType = "body", dataType = "long"),
            @ApiImplicitParam(name = "articleId", value = "文章id", required = true, paramType = "body", dataType = "long"),
    })
    @PostMapping
    void add(@RequestBody Comment comment);

    @ApiOperation(value = "修改评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章的id", required = true, paramType = "path", dataType = "long"),
            @ApiImplicitParam(name = "selection", value = "true：只修改传值不为空的字段，false：修改所有字段", required = false, paramType = "query"),
            @ApiImplicitParam(name = "content", value = "评论内容", required = true, paramType = "body", dataType = "string"),
            @ApiImplicitParam(name = "contextType", value = "文章内容类型", required = true, paramType = "body", dataType = "string"),
    })
    @PutMapping("/{id}")
    void update(@RequestParam(value = "selection", required = false, defaultValue = "true") Boolean selection,
                @PathVariable("id") Long id,
                @RequestBody Comment comment);

    @ApiOperation(value = "删除评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "评论的id", required = true, paramType = "path", dataType = "long")
    })
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}
