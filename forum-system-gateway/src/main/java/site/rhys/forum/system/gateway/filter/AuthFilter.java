package site.rhys.forum.system.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import site.rhys.forum.service.auth.api.dto.PermissionDto;
import site.rhys.forum.service.auth.api.model.HttpMethod;
import site.rhys.forum.system.gateway.manager.AuthManager;

import java.net.URL;
import java.util.Map;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/13 21:09
 * @since 1.0.0
 */
@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private AuthManager authManager;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();

        // 获取token
        Map<String, String> headers = requestContext.getZuulRequestHeaders();
        String token = null;
        if (headers != null) {
            token = headers.get(HttpHeaders.AUTHORIZATION);
        }
        PermissionDto permissionDto = new PermissionDto();
        permissionDto.setToken(token);

        URL routeHost = requestContext.getRouteHost();

        permissionDto.setUrl(routeHost.getPath());

        permissionDto.setMethod(format(requestContext.getRequest().getMethod()));
        if (!authManager.isPermitted(permissionDto)) {
            requestContext.getResponse().setStatus(HttpStatus.SC_UNAUTHORIZED);
        }
        return null;
    }

    private HttpMethod format(String methodStr) {
        HttpMethod[] httpMethods = {
                HttpMethod.GET,
                HttpMethod.PATCH,
                HttpMethod.POST,
                HttpMethod.DELETE
        };
        for (HttpMethod method : httpMethods) {
            if (method.name().equalsIgnoreCase(methodStr)) {
                return method;
            }
        }
        return null;
    }
}
