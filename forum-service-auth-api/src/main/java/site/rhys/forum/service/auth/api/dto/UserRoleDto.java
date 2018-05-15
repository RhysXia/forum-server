package site.rhys.forum.service.auth.api.dto;

import lombok.Data;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 19:42
 * @since 1.0.0
 */
@Data
public class UserRoleDto {

    private Long userId;

    private Long[] roleIds;

}
