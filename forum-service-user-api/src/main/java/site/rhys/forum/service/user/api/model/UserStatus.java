package site.rhys.forum.service.user.api.model;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 16:31
 * @since 1.0.0
 * 用户状态
 */
public enum UserStatus {
    /**
     * 激活状态
     */
    ACTIVATED,
    /**
     * 未激活
     */
    DISACTIVATED,
    /**
     * 删除
     */
    DELETED,
    /**
     * 冻结
     */
    FROZEN

}
