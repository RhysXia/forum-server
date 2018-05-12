package site.rhys.forum.service.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.article.api.api.ArticleApi;
import site.rhys.forum.service.article.api.model.Article;
import site.rhys.forum.service.article.manager.UserManager;
import site.rhys.forum.service.article.service.ArticleService;
import site.rhys.forum.service.user.api.model.User;

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

    @Autowired
    private UserManager userManager;

    @Override
    public Article findById(@PathVariable("id") Long id) {
        return articleService.selectById(id);
    }

    @GetMapping("/user/{id}")
    public User findById2(@PathVariable("id") Long id) {
        return userManager.findById(id);
    }
}
