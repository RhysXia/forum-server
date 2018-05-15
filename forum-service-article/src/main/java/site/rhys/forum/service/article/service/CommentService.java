package site.rhys.forum.service.article.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.rhys.forum.service.article.api.dto.AddCommentDto;
import site.rhys.forum.service.article.api.model.Comment;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 21:30
 * @since 1.0.0
 */
public interface CommentService {

    Page<Comment> findAllByAuthorId(Long authorId, Pageable pageable);

    Comment findById(Long id);

    Page<Comment> findAllByArticleId(Long articleId, Pageable pageable);

    Page<Comment> findAllByParentId(Long parentId, Pageable pageable);

    Long add(AddCommentDto comment);

    void deleteById(Long id);
}
