package site.rhys.forum.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 22:25
 */
@Data
public class Category {
    private Long id;
    private String name;
    private String description;
    private Date createAt;
    private Long authorId;
    private Long articleNum;
    /**
     * 权重
     */
    private Integer weight;
}
