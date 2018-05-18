package site.rhys.forum.service.article.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.service.article.api.dto.AddArticleDto;
import site.rhys.forum.service.article.api.dto.UpdateArticleDto;
import site.rhys.forum.service.article.api.model.Article;
import site.rhys.forum.service.article.api.model.Category;
import site.rhys.forum.service.article.repository.ArticleRepository;
import site.rhys.forum.service.article.repository.CategoryRepository;
import site.rhys.forum.service.article.service.ArticleService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 19:29
 * @since 1.0.0
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Article findById(Long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Page<Article> findAllByAuthorId(Long authorId, Pageable pageable) {
        return articleRepository.findAllByAuthorId(authorId, pageable);
    }

    @Override
    public Page<Article> findAllByCategoryId(Long categoryId, Pageable pageable) {
        return articleRepository.findAllByCategoryId(categoryId, pageable);
    }

    @Transactional
    @Override
    public Article add(AddArticleDto article) {
        if (article.getTitle() == null) {
            log.error("标题不能为空");
            throw new IllegalArgumentException("标题不能为空");
        }
        if (article.getContext() == null) {
            log.error("内容不能为空");
            throw new IllegalArgumentException("内容不能为空");
        }
        if (article.getContextType() == null) {
            log.error("内容类型不能为空");
            throw new IllegalArgumentException("内容类型不能为空");
        }

        if (article.getCategoryId() == null) {
            log.error("文章分类id不能为空");
            throw new IllegalArgumentException("文章分类id不能为空");
        }

        Category category = categoryRepository.findOne(article.getCategoryId());
        if (category == null) {
            log.error("文章分类不存在");
            throw new IllegalArgumentException("文章分类不存在");
        }

        //修改分类下的文章总数
        category.setArticleCount(category.getArticleCount() + 1);

        //保存
        categoryRepository.save(category);


        Article newArticle = new Article();
        BeanUtils.copyProperties(article, newArticle);

        newArticle.setCommentCount(0L);

        //设置作者
        newArticle.setAuthorId(category.getAuthorId());

        Date date = new Date();
        newArticle.setCreateAt(date);
        newArticle.setUpdateAt(date);

        return articleRepository.save(newArticle);
    }

    @Transactional
    @Override
    public Article updateSelectionById(Long id, UpdateArticleDto article) {
        Article oldArticle = articleRepository.findOne(id);
        if (oldArticle == null) {
            log.error("文章不存在");
            throw new IllegalArgumentException("文章不存在");
        }
        if (article.getTitle() != null) {
            oldArticle.setTitle(article.getTitle());
        }
        if (article.getContext() != null) {
            oldArticle.setContext(article.getContext());
        }
        if (article.getContextType() != null) {
            oldArticle.setContextType(article.getContextType());
        }
        if (article.getCategoryId() != null) {
            Category newCategory = categoryRepository.findOne(article.getCategoryId());
            if (newCategory == null) {
                log.error("文章分类不存在");
                throw new IllegalArgumentException("文章分类不存在");
            }
            //判断分类是否是原来的用户的
            if (!oldArticle.getAuthorId().equals(newCategory.getAuthorId())) {
                log.error("分类不属于该作者");
                throw new IllegalArgumentException("分类不属于该作者");
            }

            //减少之前分类下的文章数
            Category oldCategory = categoryRepository.findOne(oldArticle.getCategoryId());
            oldCategory.setArticleCount(oldCategory.getArticleCount() - 1);
            //增加现在分类下的文章数
            newCategory.setArticleCount(newCategory.getArticleCount() + 1);
            //保存
            categoryRepository.save(Arrays.asList(oldCategory, newCategory));

            oldArticle.setCategoryId(article.getCategoryId());
        }

        return articleRepository.save(oldArticle);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Article oldArticle = articleRepository.findOne(id);
        if (oldArticle == null) {
            log.error("文章不存在");
            throw new IllegalArgumentException("文章不存在");
        }
        // 删除分类下的文章数
        Category category = categoryRepository.findOne(oldArticle.getCategoryId());
        category.setArticleCount(category.getArticleCount() - 1);
        categoryRepository.save(category);
        articleRepository.delete(oldArticle);
    }

    @Transactional
    @Override
    public void deleteAllByCategoryId(Long categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        if (category == null) {
            log.error("文章分类不存在");
            throw new IllegalArgumentException("文章分类不存在");
        }
        // 删除分类下的文章数
        category.setArticleCount(0L);
        categoryRepository.save(category);
        articleRepository.deleteAllByCategoryId(categoryId);
    }
}
