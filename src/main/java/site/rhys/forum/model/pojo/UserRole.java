package site.rhys.forum.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 22:22
 */
@Data
public class UserRole {
    private Long userId;
    private Long roleId;
    private Date createAt;
}
