package site.rhys.forum.service.article.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.rhys.forum.service.article.api.model.Article;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:28
 * @since 1.0.0
 */
public interface ArticleService {
    Article findById(Long id);

    Page<Article> findByPage(Pageable pageable);
}
