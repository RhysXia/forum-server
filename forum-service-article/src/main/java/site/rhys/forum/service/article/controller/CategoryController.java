package site.rhys.forum.service.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.article.api.api.CategoryApi;
import site.rhys.forum.service.article.api.dto.AddCategoryDto;
import site.rhys.forum.service.article.api.dto.UpdateCategoryDto;
import site.rhys.forum.service.article.api.model.Category;
import site.rhys.forum.service.article.service.CategoryService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 20:37
 * @since 1.0.0
 */
@RestController
@Slf4j
public class CategoryController implements CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        return categoryService.findAll(pageable);
    }

    @Override
    public Page<Category> findAllByAuthorId(Long authorId, Pageable pageable) {
        log.debug("findAllByAuthorId: authorId-> {}, pageable-> {}", authorId, pageable);
        return categoryService.findAllByAuthorId(authorId, pageable);
    }

    @Override
    public Category findById(Long id) {
        log.debug("findById: id-> {}", id);
        return categoryService.findById(id);
    }

    @Override
    public Long add(AddCategoryDto category) {
        log.debug("add: category-> {}", category);
        return categoryService.add(category);
    }

    @Override
    public void updateSelectionById(Long id, UpdateCategoryDto category) {
        log.debug("updateSelectionById: id-> {}, category-> {}", id, category);

        categoryService.updateSelectionById(id, category);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);

        categoryService.deleteById(id);
    }
}
