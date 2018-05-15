package site.rhys.forum.service.article.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.service.article.api.dto.AddCategoryDto;
import site.rhys.forum.service.article.api.dto.UpdateCategoryDto;
import site.rhys.forum.service.article.api.model.Category;
import site.rhys.forum.service.article.manager.UserManager;
import site.rhys.forum.service.article.repository.CategoryRepository;
import site.rhys.forum.service.article.service.CategoryService;
import site.rhys.forum.service.user.api.model.User;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 20:40
 * @since 1.0.0
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserManager userManager;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Page<Category> findAllByAuthorId(Long authorId, Pageable pageable) {
        return categoryRepository.findAllByAuthorId(authorId, pageable);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Transactional
    @Override
    public Long add(AddCategoryDto category) {

        if (category.getName() == null) {
            log.error("名称不能为空");
            throw new IllegalArgumentException("名称不能为空");
        }
        if (category.getDescription() == null) {
            log.error("描述不能为空");
            throw new IllegalArgumentException("描述不能为空");
        }
        if (category.getAuthorId() != null) {
            User user = userManager.findById(category.getAuthorId());
            if (user == null) {
                log.error("作者不存在");
                throw new IllegalArgumentException("作者不存在");
            }
        }
        Category newCategory = new Category();
        BeanUtils.copyProperties(category, newCategory);
        newCategory.setArticleCount(0L);
        newCategory.setCreateAt(new Date());
        return categoryRepository.save(newCategory).getId();
    }

    @Transactional
    @Override
    public void updateSelectionById(Long id, UpdateCategoryDto category) {

        Category oldCategory = categoryRepository.findOne(id);

        if (oldCategory == null) {
            log.error("分类不存在");
            throw new IllegalArgumentException("分类不存在");
        }

        if (category.getName() != null) {
            oldCategory.setName(category.getName());
        }
        if (category.getDescription() != null) {
            oldCategory.setDescription(category.getDescription());
        }

        categoryRepository.save(oldCategory);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Category oldCategory = categoryRepository.findOne(id);

        if (oldCategory == null) {
            log.error("分类不存在");
            throw new IllegalArgumentException("分类不存在");
        }

        if (oldCategory.getArticleCount() > 0) {
            log.error("分类下有文章,无法删除");
            throw new IllegalArgumentException("分类下有文章,无法删除");
        }
        categoryRepository.delete(id);
    }
}
