package site.rhys.forum.service.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.pojo.Article;
import site.rhys.forum.service.article.mapper.ArticleMapper;
import site.rhys.forum.service.article.service.ArticleService;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 19:37
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article findById(Long id) {
        return articleMapper.selectById(id);
    }
}
