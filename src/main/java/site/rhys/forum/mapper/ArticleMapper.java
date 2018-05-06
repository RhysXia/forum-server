package site.rhys.forum.mapper;

import site.rhys.forum.model.pojo.Article;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 22:48
 */
public interface ArticleMapper {
    Article selectById(Long id);
}
