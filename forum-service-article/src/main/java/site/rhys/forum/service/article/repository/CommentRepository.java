package site.rhys.forum.service.article.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import site.rhys.forum.service.article.api.model.Comment;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:49
 * @since 1.0.0
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByAuthorId(Long authorId, Pageable pageable);

    Page<Comment> findAllByArticleId(Long articleId, Pageable pageable);

    Page<Comment> findAllByParentId(Long parentId, Pageable pageable);

    Long countByParentId(Long parentId);

    Long countByArticleId(Long articleId);
}
