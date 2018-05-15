package site.rhys.forum.service.article.api.dto;

import lombok.Data;
import site.rhys.forum.service.article.api.model.ContextType;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 18:51
 * @since 1.0.0
 */
@Data
public class AddCommentDto {

    /**
     * 评论内容
     */
    private String content;
    /**
     * 内容类型
     */
    private ContextType contextType;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 评论对应的文章id
     */
    private Long articleId;

    /**
     * 父评论id,如果没有则为null
     */
    private Long parentId;

}
