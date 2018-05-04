package site.rhys.forum.common.pojo;

import lombok.Data;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 18:46
 */
@Data
public class RolePermission {

    private Long id;

    private Long roleId;

    private Long permissionId;
}
