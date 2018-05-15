package site.rhys.forum.service.auth.api.dto;

import site.rhys.forum.service.auth.api.model.HttpMethod;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 19:38
 * @since 1.0.0
 */
public class PermissionDto {

    /**
     * 请求的url，支持ant风格表达式
     */
    private String url;


    private HttpMethod method;

}
