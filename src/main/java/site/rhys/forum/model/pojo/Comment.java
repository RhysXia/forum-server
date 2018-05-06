package site.rhys.forum.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 22:30
 */
@Data
public class Comment {
    private Long id;
    private String content;
    private Date createAt;
    private Date updateAt;
    private Long parentId;
    private Long articleId;
    private Long authorId;
    private ContentType contentType;
}
