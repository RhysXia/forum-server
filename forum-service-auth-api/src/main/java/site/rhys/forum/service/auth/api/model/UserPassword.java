package site.rhys.forum.service.auth.api.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-19 17:26
 * 用户与密码的对应关系
 */
@Data
@Entity
@Table(indexes = {
        @Index(columnList = "userId")
})
public class UserPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String password;
}
