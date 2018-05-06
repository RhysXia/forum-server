package site.rhys.forum.service.article.mapper;

import site.rhys.forum.common.pojo.Article;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 19:38
 */
public interface ArticleMapper {
    Article selectById(Long id);
}
