package site.rhys.forum.service.auth.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 16:42
 * @since 1.0.0
 */
@Data
@Entity
@Table(indexes = {
        @Index(columnList = "roleId"),
        @Index(columnList = "userId")
})
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long roleId;

    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
