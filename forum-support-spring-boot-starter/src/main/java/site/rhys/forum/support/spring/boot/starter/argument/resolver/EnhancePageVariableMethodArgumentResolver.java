package site.rhys.forum.support.spring.boot.starter.argument.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver;
import org.springframework.web.util.UriComponentsBuilder;
import site.rhys.forum.support.spring.boot.starter.utils.ClassUtils;

import java.util.Map;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/12 19:27
 * @since 1.0.0
 * <p>
 * 对默认的方法参数注解的增强 支持继承
 */
public class EnhancePageVariableMethodArgumentResolver extends PathVariableMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        MethodParameter methodParameter = ClassUtils.getInterfaceMethodParameter(parameter, PathVariable.class);
        return super.supportsParameter(methodParameter);
    }

    @Override
    protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
        MethodParameter methodParameter = ClassUtils.getInterfaceMethodParameter(parameter, PathVariable.class);
        return super.createNamedValueInfo(methodParameter);
    }

    @Override
    public void contributeMethodArgument(MethodParameter parameter, Object value,
                                         UriComponentsBuilder builder, Map<String, Object> uriVariables, ConversionService conversionService) {

        MethodParameter methodParameter = ClassUtils.getInterfaceMethodParameter(parameter, PathVariable.class);
        super.contributeMethodArgument(methodParameter, value, builder, uriVariables, conversionService);
    }

}
