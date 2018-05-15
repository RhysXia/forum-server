package site.rhys.forum.service.article.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.article.api.dto.AddCommentDto;
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


    @ApiOperation(value = "分页查询文章下的评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true, paramType = "path", dataType = "long"),
    })
    @GetMapping
    Page<Comment> findAllByArticleId(@RequestParam("articleId") Long articleId,
                                     @PageableDefault Pageable pageable);

    @ApiOperation(value = "查询指定用户的评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorId", value = "作者的id", required = true, paramType = "path", dataType = "long"),
    })
    @GetMapping
    Page<Comment> findAllByAuthorId(@RequestParam("authorId") Long authorId,
                                     @PageableDefault Pageable pageable);

    @ApiOperation(value = "根据父评论id查询评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父分类的id", required = true, paramType = "query", dataType = "long"),

    })
    @GetMapping
    Page<Comment> findAllByParentId(@RequestParam("parentId") Long parentId, @PageableDefault Pageable pageable);

    @ApiOperation(value = "添加评论,返回成功后的id")
    @PostMapping
    Long add(@RequestBody AddCommentDto comment);

    @ApiOperation(value = "删除评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "评论的id", required = true, paramType = "path", dataType = "long")
    })
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}
