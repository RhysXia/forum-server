package site.rhys.forum.service.article.api.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/11 22:16
 * @since 1.0.0
 * 文章分类
 */
@Data
public class Category {
    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 文章总数
     */
    private Long articleCount;
}
