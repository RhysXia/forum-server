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
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Date createAt;
    private UserStatus status;
    private Gender gender;
}
