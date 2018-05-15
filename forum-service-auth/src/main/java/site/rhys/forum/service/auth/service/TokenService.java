package site.rhys.forum.service.auth.service;

import site.rhys.forum.service.auth.api.dto.TokenDto;
import site.rhys.forum.service.auth.api.model.Token;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 23:23
 * @since 1.0.0
 */
public interface TokenService {
    Token signIn(TokenDto tokenDto);

    void signOut(String token);
}
