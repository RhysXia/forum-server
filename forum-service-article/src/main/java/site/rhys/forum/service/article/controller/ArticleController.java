package site.rhys.forum.service.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.article.api.api.ArticleApi;
import site.rhys.forum.service.article.api.model.Article;
import site.rhys.forum.service.article.api.model.Comment;
import site.rhys.forum.service.article.service.ArticleService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:21
 * @since 1.0.0
 */
@RestController
public class ArticleController implements ArticleApi {
    @Autowired
    private ArticleService articleService;

    @Override
    public Page<Article> findByPage(Pageable pageable) {

        return articleService.findByPage(pageable);
    }

    @Override
    public Page<Comment> findArticlesByPage(Long articleIds, Pageable pageable) {
        return null;
    }

    @Override
    public Article findById(Long id) {
        return articleService.findById(id);
    }

    @Override
    public void add(Article article) {

    }

    @Override
    public void update(Boolean selection, Long id, Article article) {

    }

    @Override
    public void deleteById(Long id) {

    }

}
