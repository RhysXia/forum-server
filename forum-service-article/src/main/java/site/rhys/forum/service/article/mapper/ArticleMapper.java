package site.rhys.forum.service.article.mapper;

import site.rhys.forum.service.article.api.model.Article;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:49
 * @since 1.0.0
 */
public interface ArticleMapper {
    Article selectById(Long id);
}
