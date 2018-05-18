package site.rhys.forum.service.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.vo.ResultVo;
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
    public ResultVo<Page<Category>> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        Page<Category> page = categoryService.findAll(pageable);
        return ResultVo.success("获取文章分类列表成功", page);
    }

    @Override
    public ResultVo<Page<Category>> findAllByAuthorId(Long authorId, Pageable pageable) {
        log.debug("findAllByAuthorId: authorId-> {}, pageable-> {}", authorId, pageable);
        Page<Category> page = categoryService.findAllByAuthorId(authorId, pageable);
        return ResultVo.success("获取文章分类列表成功", page);
    }

    @Override
    public ResultVo<Category> findById(Long id) {
        log.debug("findById: id-> {}", id);
        Category category = categoryService.findById(id);
        return ResultVo.success("获取文章分类成功", category);
    }

    @Override
    public ResultVo<Category> add(AddCategoryDto category) {
        log.debug("add: category-> {}", category);
        Category res = categoryService.add(category);
        return ResultVo.success("添加文章分类成功", res);
    }

    @Override
    public ResultVo<Category> updateSelectionById(Long id, UpdateCategoryDto category) {
        log.debug("updateSelectionById: id-> {}, category-> {}", id, category);

        Category res = categoryService.updateSelectionById(id, category);
        return ResultVo.success("更新文章分类成功", res);
    }

    @Override
    public ResultVo<Void> deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);

        categoryService.deleteById(id);
        return ResultVo.success("删除文章分类成功", null);
    }
}
