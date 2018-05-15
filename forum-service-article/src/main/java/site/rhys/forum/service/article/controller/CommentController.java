package site.rhys.forum.service.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
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
    public Page<Comment> findAllByAuthorId(Long authorId, Pageable pageable) {
        log.debug("findAllByAuthorId: authorId-> {}, pageable-> {}", authorId, pageable);
        return commentService.findAllByAuthorId(authorId, pageable);
    }

    @Override
    public Comment findById(Long id) {
        log.debug("findById: id-> {}", id);
        return commentService.findById(id);
    }

    @Override
    public Page<Comment> findAllByArticleId(Long articleId, Pageable pageable) {
        log.debug("findAllByArticleId: articleId-> {}, pageable-> {}", articleId, pageable);
        return commentService.findAllByArticleId(articleId, pageable);
    }

    @Override
    public Page<Comment> findAllByParentId(Long parentId, Pageable pageable) {
        log.debug("findAllByParentId: parentId-> {}, pageable-> {}", parentId, pageable);
        return commentService.findAllByParentId(parentId, pageable);
    }

    @Override
    public Long add(AddCommentDto comment) {
        log.debug("add: category-> {}", comment);
        return commentService.add(comment);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);
        commentService.deleteById(id);
    }
}
