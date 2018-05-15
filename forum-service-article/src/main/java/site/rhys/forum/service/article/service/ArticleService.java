package site.rhys.forum.service.article.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.rhys.forum.service.article.api.dto.AddArticleDto;
import site.rhys.forum.service.article.api.dto.UpdateArticleDto;
import site.rhys.forum.service.article.api.model.Article;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:28
 * @since 1.0.0
 */
public interface ArticleService {
    Article findById(Long id);

    Page<Article> findAll(Pageable pageable);

    Page<Article> findAllByAuthorId(Long authorId, Pageable pageable);

    Page<Article> findAllByCategoryId(Long categoryId, Pageable pageable);

    Long add(AddArticleDto article);

    void updateSelectionById(Long id, UpdateArticleDto article);

    void deleteById(Long id);

    void deleteAllByCategoryId(Long categoryId);
}
