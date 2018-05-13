package site.rhys.forum.service.article.api.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:48
 * @since 1.0.0
 * <p>
 * 文章
 */
@Data
public class Article {
    /**
     * id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String context;
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
     * 评论数
     */
    private Long commentCount;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 作者id
     */
    private Long categoryId;
}
