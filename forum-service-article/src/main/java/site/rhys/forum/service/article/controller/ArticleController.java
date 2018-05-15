package site.rhys.forum.service.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
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
    public Page<Article> findAll(Pageable pageable) {
        log.debug("findAll: pageable-> {}", pageable);
        return articleService.findAll(pageable);
    }

    @Override
    public Page<Article> findAllByAuthorId(Long authorId, Pageable pageable) {
        log.debug("findAllByAuthorId: authorId-> {}, pageable-> {}", authorId, pageable);
        return articleService.findAllByAuthorId(authorId, pageable);
    }

    @Override
    public Page<Article> findAllByCategoryId(Long categoryId, Pageable pageable) {
        log.debug("findAllByCategoryId: categoryId-> {}, pageable-> {}", categoryId, pageable);
        return articleService.findAllByCategoryId(categoryId, pageable);
    }

    @Override
    public Article findById(Long id) {
        log.debug("findById: id-> {}", id);
        return articleService.findById(id);
    }

    @Override
    public Long add(AddArticleDto article) {
        log.debug("findById: article-> {}", article);
        return articleService.add(article);
    }

    @Override
    public void updateSelectionById(Long id, UpdateArticleDto article) {
        log.debug("updateSelectionById: id-> {}, article-> {}", id, article);
        articleService.updateSelectionById(id, article);

    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById: id-> {}", id);
        articleService.deleteById(id);
    }

    @Override
    public void deleteAllByCategoryId(Long categoryId) {
        log.debug("deleteAllByCategoryId: categoryId-> {}", categoryId);
        articleService.deleteAllByCategoryId(categoryId);
    }
}
