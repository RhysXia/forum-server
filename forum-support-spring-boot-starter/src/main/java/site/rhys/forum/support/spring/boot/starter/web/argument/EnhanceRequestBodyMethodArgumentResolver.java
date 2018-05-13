package site.rhys.forum.support.spring.boot.starter.web.argument;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import site.rhys.forum.support.spring.boot.starter.utils.ClassUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/12 19:27
 * @since 1.0.0
 * <p>
 * 对默认的方法参数注解的增强 支持继承
 */
public class EnhanceRequestBodyMethodArgumentResolver extends RequestResponseBodyMethodProcessor {


    public EnhanceRequestBodyMethodArgumentResolver(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    public EnhanceRequestBodyMethodArgumentResolver(List<HttpMessageConverter<?>> converters, ContentNegotiationManager manager) {
        super(converters, manager);
    }

    public EnhanceRequestBodyMethodArgumentResolver(List<HttpMessageConverter<?>> converters, List<Object> requestResponseBodyAdvice) {
        super(converters, requestResponseBodyAdvice);
    }

    public EnhanceRequestBodyMethodArgumentResolver(List<HttpMessageConverter<?>> converters, ContentNegotiationManager manager, List<Object> requestResponseBodyAdvice) {
        super(converters, manager, requestResponseBodyAdvice);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        MethodParameter methodParameter = ClassUtils.getInterfaceMethodParameter(parameter, RequestBody.class);
        return super.supportsParameter(methodParameter);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        MethodParameter methodParameter = ClassUtils.getInterfaceMethodParameter(parameter, RequestBody.class);
        return super.resolveArgument(methodParameter, mavContainer, webRequest, binderFactory);

    }

    @Override
    protected <T> Object readWithMessageConverters(NativeWebRequest webRequest, MethodParameter parameter,
                                                   Type paramType) throws IOException, HttpMediaTypeNotSupportedException, HttpMessageNotReadableException {

        MethodParameter methodParameter = ClassUtils.getInterfaceMethodParameter(parameter, RequestBody.class);
        return super.readWithMessageConverters(webRequest, methodParameter, paramType);
    }

}
