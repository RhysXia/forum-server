package site.rhys.forum.support.spring.boot.starter.argument.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import site.rhys.forum.support.spring.boot.starter.utils.ClassUtils;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/12 19:27
 * @since 1.0.0
 * <p>
 * 对默认的方法参数注解的增强 支持继承
 */
public class EnhanceRequestParamMapMethodArgumentResolver extends RequestParamMapMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        MethodParameter methodParameter = ClassUtils.getInterfaceMethodParameter(parameter, RequestParam.class);
        return super.supportsParameter(methodParameter);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        MethodParameter methodParameter = ClassUtils.getInterfaceMethodParameter(parameter, RequestParam.class);
        return super.resolveArgument(methodParameter, mavContainer, webRequest, binderFactory);

    }

}
