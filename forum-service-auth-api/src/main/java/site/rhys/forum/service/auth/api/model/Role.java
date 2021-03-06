package site.rhys.forum.service.auth.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:48
 * @since 1.0.0
 */
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
