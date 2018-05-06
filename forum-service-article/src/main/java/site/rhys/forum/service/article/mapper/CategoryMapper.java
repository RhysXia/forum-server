package site.rhys.forum.service.article.mapper;

import site.rhys.forum.common.pojo.Category;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 21:10
 */
public interface CategoryMapper {
    Category selectById(Long id);
}
