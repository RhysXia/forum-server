package site.rhys.forum.service.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.rhys.forum.service.article.api.model.Article;
import site.rhys.forum.service.article.repository.ArticleRepository;
import site.rhys.forum.service.article.service.ArticleService;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:29
 * @since 1.0.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article findById(Long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Page<Article> findByPage(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }
}
