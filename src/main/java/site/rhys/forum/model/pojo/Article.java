package site.rhys.forum.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 22:27
 */
@Data
public class Article {
    private Long id;
    private Long authorId;
    private Long categoryId;
    private ContentType contentType;
    private String title;
    private String content;
    private Date createAt;
    private Date updateAt;

    private Long commentNum;
}
