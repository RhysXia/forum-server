package site.rhys.forum.service.article.api.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 22:31
 * @since 1.0.0
 */
@Data
public class Comment {
    /**
     * id
     */
    private Long id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 内容类型
     */
    private ContextType contextType;
    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

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

    /**
     * 楼层
     */
    private Long floorNum;
}
