package site.rhys.forum.service.article.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.service.article.api.dto.AddCommentDto;
import site.rhys.forum.service.article.api.model.Article;
import site.rhys.forum.service.article.api.model.Comment;
import site.rhys.forum.service.article.repository.ArticleRepository;
import site.rhys.forum.service.article.repository.CommentRepository;
import site.rhys.forum.service.article.service.CommentService;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 21:30
 * @since 1.0.0
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Comment> findAllByAuthorId(Long authorId, Pageable pageable) {
        return commentRepository.findAllByAuthorId(authorId, pageable);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Page<Comment> findAllByArticleId(Long articleId, Pageable pageable) {
        return commentRepository.findAllByArticleId(articleId, pageable);
    }

    @Override
    public Page<Comment> findAllByParentId(Long parentId, Pageable pageable) {
        return commentRepository.findAllByParentId(parentId, pageable);
    }

    @Transactional
    @Override
    public Long add(AddCommentDto comment) {
        if (comment.getContent() == null) {
            log.error("评论内容不能为空");
            throw new IllegalArgumentException("评论内容不能为空");
        }

        if (comment.getContextType() == null) {
            log.error("评论内容类型不能为空");
            throw new IllegalArgumentException("评论内容类型不能为空");
        }
        if (comment.getArticleId() == null) {
            log.error("文章id不能为空");
            throw new IllegalArgumentException("文章id不能为空");
        }
        if (comment.getAuthorId() == null) {
            log.error("作者id不能为空");
            throw new IllegalArgumentException("作者id不能为空");
        }

        Article article = articleRepository.findOne(comment.getArticleId());
        if (article == null) {
            log.error("文章不存在");
            throw new IllegalArgumentException("文章不存在");
        }
        if (comment.getParentId() != null) {
            Comment parent = commentRepository.findOne(comment.getParentId());
            if (parent == null) {
                log.error("父评论不存在");
                throw new IllegalArgumentException("父评论不存在");
            }
            if (!parent.getArticleId().equals(comment.getAuthorId())) {
                log.error("父评论和和该评论对应的文章不相同");
                throw new IllegalArgumentException("父评论和和该评论对应的文章不相同");
            }
        }

        //文章评论+1
        article.setCommentCount(article.getCommentCount() + 1);

        articleRepository.save(article);

        Comment newComment = new Comment();
        BeanUtils.copyProperties(comment, newComment);

        Long floorNum = 0L;
        //如果父分类存在，获取其下评论总数
        if (comment.getParentId() != null) {
            floorNum = commentRepository.countByParentId(comment.getParentId());
        } else {
            floorNum = commentRepository.countByArticleId(comment.getArticleId());
        }

        newComment.setFloorNum(floorNum);
        newComment.setCreateAt(new Date());

        return commentRepository.save(newComment).getId();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Comment comment = commentRepository.findOne(id);
        if (comment == null) {
            log.error("评论不存在");
            throw new IllegalArgumentException("评论不存在");
        }
        //减少文章下的评论总数
        Article article = articleRepository.findOne(comment.getArticleId());
        article.setCommentCount(article.getCommentCount() - 1);
        articleRepository.save(article);
        commentRepository.delete(id);
    }
}
