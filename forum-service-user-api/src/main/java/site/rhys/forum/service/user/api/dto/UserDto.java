package site.rhys.forum.service.user.api.dto;

import lombok.Data;
import site.rhys.forum.service.user.api.model.Gender;
import site.rhys.forum.service.user.api.model.UserStatus;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 16:56
 * @since 1.0.0
 */
@Data
public class UserDto {

    private String username;

    private String nickname;

    private UserStatus status;

    private String info;

    private String email;

    private Gender gender;

}
