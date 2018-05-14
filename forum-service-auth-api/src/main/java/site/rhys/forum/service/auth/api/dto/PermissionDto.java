package site.rhys.forum.service.auth.api.dto;

import lombok.Getter;
import lombok.Setter;
import site.rhys.forum.service.auth.api.model.HttpMethod;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 21:57
 * @since 1.0.0
 */
@Getter
@Setter
public class PermissionDto {
    private String token;
    private String url;
    private HttpMethod method;
}
