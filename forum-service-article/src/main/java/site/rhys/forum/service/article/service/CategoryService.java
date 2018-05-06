package site.rhys.forum.service.article.service;

import site.rhys.forum.common.pojo.Category;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 21:07
 */
public interface CategoryService {
    Category findById(Long id);
}
