package site.rhys.forum.service.article.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.rhys.forum.service.article.api.dto.AddCategoryDto;
import site.rhys.forum.service.article.api.dto.UpdateCategoryDto;
import site.rhys.forum.service.article.api.model.Category;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 20:40
 * @since 1.0.0
 */
public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Page<Category> findAllByAuthorId(Long authorId, Pageable pageable);

    Category findById(Long id);

    Long add(AddCategoryDto category);

    void updateSelectionById(Long id, UpdateCategoryDto category);

    void deleteById(Long id);
}
