package site.rhys.forum.service.article.service;

import site.rhys.forum.common.pojo.Article;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 19:36
 */
public interface ArticleService {
    /**
     * 根据id查找文章
     *
     * @param id
     * @return
     */
    Article findById(Long id);
}
