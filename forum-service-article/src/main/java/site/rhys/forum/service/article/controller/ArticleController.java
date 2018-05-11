package site.rhys.forum.service.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.article.api.api.ArticleApi;
import site.rhys.forum.service.article.api.model.Article;
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
    public Article findById(Long id) {
        return articleService.selectById(id);
    }
}
