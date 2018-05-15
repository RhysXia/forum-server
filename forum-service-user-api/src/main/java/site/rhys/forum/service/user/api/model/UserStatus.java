package site.rhys.forum.service.user.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 16:31
 * @since 1.0.0
 * 用户状态
 */
@ApiModel("用户状态")
public enum UserStatus {
    /**
     * 激活状态
     */
    @ApiModelProperty("已激活")
    ACTIVATED,
    /**
     * 未激活
     */
    @ApiModelProperty("未激活")
    DISACTIVATED,
    /**
     * 删除
     */
    @ApiModelProperty("已删除")
    DELETED,
    /**
     * 冻结
     */
    @ApiModelProperty("冻结")
    FROZEN

}
