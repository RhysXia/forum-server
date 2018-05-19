package site.rhys.forum.service.user.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("用户")
public class User {
    @ApiModelProperty("id,不需要传入，自动生成")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("性别")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ApiModelProperty("用户状态")
    @Enumerated(EnumType.STRING)
    private UserStatus status;


    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String info;

    @ApiModelProperty("创建时间")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
