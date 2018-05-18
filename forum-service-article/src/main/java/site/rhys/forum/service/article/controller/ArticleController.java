package site.rhys.forum.service.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.article.api.api.ArticleApi;
import site.rhys.forum.service.article.api.dto.AddArticleDto;
import site.rhys.forum.service.article.api.dto.UpdateArticleDto;
import site.rhys.forum.service.article.api.model.Article;
import site.rhys.forum.service.article.service.ArticleService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:21
 * @since 1.0.0
 */
@RestController
@Slf4j
public class ArticleController implements ArticleApi {
    @Autowired
    private ArticleService articleService;


    @Override
    public ResultVo<Page<Article>> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        Page<Article> page = articleService.findAll(pageable);
        return ResultVo.success("获取文章列表成功", page);
    }

    @Override
    public ResultVo<Page<Article>> findAllByAuthorId(Long authorId, Pageable pageable) {
        log.debug("findAllByAuthorId: authorId-> {}, pageable-> {}", authorId, pageable);
        Page<Article> page = articleService.findAllByAuthorId(authorId, pageable);
        return ResultVo.success("获取文章列表成功", page);
    }

    @Override
    public ResultVo<Page<Article>> findAllByCategoryId(Long categoryId, Pageable pageable) {
        log.debug("findAllByCategoryId: categoryId-> {}, pageable-> {}", categoryId, pageable);
        Page<Article> page = articleService.findAllByCategoryId(categoryId, pageable);
        return ResultVo.success("获取文章列表成功", page);
    }

    @Override
    public ResultVo<Article> findById(Long id) {
        log.debug("findById: id-> {}", id);
        Article article = articleService.findById(id);
        return ResultVo.success("获取文章成功", article);
    }

    @Override
    public ResultVo<Article> add(AddArticleDto article) {
        log.debug("findById: article-> {}", article);
        Article res = articleService.add(article);
        return ResultVo.success("添加文章成功", res);
    }

    @Override
    public ResultVo<Article> updateSelectionById(Long id, UpdateArticleDto article) {
        log.debug("updateSelectionById: id-> {}, article-> {}", id, article);
        Article res = articleService.updateSelectionById(id, article);
        return ResultVo.success("更新文章成功", res);

    }

    @Override
    public ResultVo<Void> deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);
        articleService.deleteById(id);
        return ResultVo.success("删除文章成功", null);
    }

    @Override
    public ResultVo<Void> deleteAllByCategoryId(Long categoryId) {
        log.debug("deleteAllByCategoryId: categoryId-> {}", categoryId);
        articleService.deleteAllByCategoryId(categoryId);
        return ResultVo.success("删除文章成功", null);
    }
}
