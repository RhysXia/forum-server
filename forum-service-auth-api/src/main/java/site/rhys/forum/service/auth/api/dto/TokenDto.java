package site.rhys.forum.service.auth.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 17:25
 * @since 1.0.0
 */
@Getter
@Setter
@ApiModel("登录用户")
public class TokenDto {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}
