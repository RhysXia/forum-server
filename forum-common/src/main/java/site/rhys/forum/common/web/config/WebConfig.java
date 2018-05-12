package site.rhys.forum.common.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import site.rhys.forum.common.web.argument.*;

import java.util.List;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/12 21:38
 * @since 1.0.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Autowired(required = false)
    private List<HttpMessageConverter<?>> converters;


    @Autowired(required = false)
    private List<Object> requestResponseBodyAdvice;


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new EnhanceRequestParamMethodArgumentResolver(false));
        argumentResolvers.add(new EnhanceRequestParamMapMethodArgumentResolver());
        argumentResolvers.add(new EnhancePageVariableMethodArgumentResolver());
        argumentResolvers.add(new EnhancePageVariableMethodArgumentResolver());
        argumentResolvers.add(new EnhancePageVariableMapMethodArgumentResolver());
        argumentResolvers.add(new EnhanceRequestBodyMethodArgumentResolver(converters, requestResponseBodyAdvice));
    }
}
