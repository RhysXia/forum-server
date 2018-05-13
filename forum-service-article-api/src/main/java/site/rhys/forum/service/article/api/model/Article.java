package site.rhys.forum.service.article.api.model;

import lombok.Data;

import javax.persistence.*;
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
@Entity
@Table(indexes = {
        @Index(columnList = "authorId"),
        @Index(columnList = "categoryId")
})
public class Article {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    @Column(columnDefinition = "TEXT")
    private String context;
    /**
     * 内容类型
     */
    @Enumerated(EnumType.STRING)
    private ContextType contextType;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
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
