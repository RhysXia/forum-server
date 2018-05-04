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
public class Permission {

    private Long id;

    private String url;

    private Method method;

    private String description;
}
