package site.rhys.forum.service.auth.api.dto;

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
public class LoginDto {
    private String username;

    private String password;
}
