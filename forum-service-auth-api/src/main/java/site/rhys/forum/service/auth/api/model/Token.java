package site.rhys.forum.service.auth.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/14 22:09
 * @since 1.0.0
 */
@Data
@Entity
@Table(indexes = {
        @Index(columnList = "userId")
})
public class Token {

    @Id
    @GeneratedValue
    private String id;


    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
