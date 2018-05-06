package site.rhys.forum.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 22:20
 */
@Data
public class Role {
    private Long id;
    private String name;
    private String description;
    private Date createAt;
}