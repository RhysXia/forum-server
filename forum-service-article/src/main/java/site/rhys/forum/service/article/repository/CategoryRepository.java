package site.rhys.forum.service.article.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import site.rhys.forum.service.article.api.model.Category;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:49
 * @since 1.0.0
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAllByAuthorId(Long authorId, Pageable pageable);
}
