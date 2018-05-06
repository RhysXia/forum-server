package site.rhys.forum.service.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.pojo.Category;
import site.rhys.forum.service.article.mapper.CategoryMapper;
import site.rhys.forum.service.article.service.CategoryService;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 21:09
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category findById(Long id) {
        return categoryMapper.selectById(id);
    }
}
