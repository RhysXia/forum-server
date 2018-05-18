package site.rhys.forum.service.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.article.api.api.CommentApi;
import site.rhys.forum.service.article.api.dto.AddCommentDto;
import site.rhys.forum.service.article.api.model.Comment;
import site.rhys.forum.service.article.service.CommentService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 20:37
 * @since 1.0.0
 */
@RestController
@Slf4j
public class CommentController implements CommentApi {
    @Autowired
    private CommentService commentService;


    @Override
    public ResultVo<Page<Comment>> findAllByAuthorId(Long authorId, Pageable pageable) {
        log.debug("findAllByAuthorId: authorId-> {}, pageable-> {}", authorId, pageable);
        Page<Comment> page = commentService.findAllByAuthorId(authorId, pageable);
        return ResultVo.success("获取评论列表成功", page);
    }

    @Override
    public ResultVo<Comment> findById(Long id) {
        log.debug("findById: id-> {}", id);
        Comment comment = commentService.findById(id);
        return ResultVo.success("获取评论成功", comment);
    }

    @Override
    public ResultVo<Page<Comment>> findAllByArticleId(Long articleId, Pageable pageable) {
        log.debug("findAllByArticleId: articleId-> {}, pageable-> {}", articleId, pageable);
        Page<Comment> page = commentService.findAllByArticleId(articleId, pageable);
        return ResultVo.success("获取评论列表成功", page);
    }

    @Override
    public ResultVo<Page<Comment>> findAllByParentId(Long parentId, Pageable pageable) {
        log.debug("findAllByParentId: parentId-> {}, pageable-> {}", parentId, pageable);
        Page<Comment> page = commentService.findAllByParentId(parentId, pageable);
        return ResultVo.success("获取评论列表成功", page);
    }

    @Override
    public ResultVo<Comment> add(AddCommentDto comment) {
        log.debug("add: category-> {}", comment);
        Comment res = commentService.add(comment);
        return ResultVo.success("添加评论成功", res);
    }

    @Override
    public ResultVo<Void> deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);
        commentService.deleteById(id);
        return ResultVo.success("删除评论成功", null);
    }
}
