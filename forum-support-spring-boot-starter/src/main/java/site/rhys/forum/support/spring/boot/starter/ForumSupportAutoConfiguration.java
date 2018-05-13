package site.rhys.forum.support.spring.boot.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import site.rhys.forum.support.spring.boot.starter.web.argument.*;

import java.util.List;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/12 21:38
 * @since 1.0.0
 */
@Configuration
public class ForumSupportAutoConfiguration {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(ContentNegotiationManager manager, List<HttpMessageConverter<?>> converters) {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
                super.addArgumentResolvers(argumentResolvers);
                argumentResolvers.add(new EnhanceRequestParamMethodArgumentResolver(false));
                argumentResolvers.add(new EnhanceRequestParamMapMethodArgumentResolver());
                argumentResolvers.add(new EnhancePageVariableMethodArgumentResolver());
                argumentResolvers.add(new EnhancePageVariableMethodArgumentResolver());
                argumentResolvers.add(new EnhancePageVariableMapMethodArgumentResolver());
                argumentResolvers.add(new EnhanceRequestBodyMethodArgumentResolver(converters, manager));
            }
        };
    }
}
