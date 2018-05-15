package site.rhys.forum.service.auth.api.dto;

import lombok.Data;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:48
 * @since 1.0.0
 */
@Data
public class RoleDto {
    private String name;

    private String description;

    private Long[] permissionIds;
}
