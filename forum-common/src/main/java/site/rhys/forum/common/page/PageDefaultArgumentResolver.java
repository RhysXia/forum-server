package site.rhys.forum.common.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rhys Xia
 * <p>
 * 2018/03/06 09:58
 * 处理{@link PageDefault}注解参数的绑定
 */
@Slf4j
public class PageDefaultArgumentResolver implements HandlerMethodArgumentResolver {


    private static final String PAGE_PARAM = "page";
    private static final String SIZE_PARAM = "size";
    private static final String SORT_PARAM = "sort";

    /**
     * 判断参数是否是PageQuery类型，且是否有PageDefault注解
     *
     * @param methodParameter
     * @return
     */
    public boolean supportsParameter(MethodParameter methodParameter) {

        return methodParameter.hasParameterAnnotation(PageDefault.class) && methodParameter.getParameterType().isAssignableFrom(PageQuery.class);
    }


    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        log.info("正在解析查询参数");

        // 获取请求参数，并进行url解码
        String pageStr = nativeWebRequest.getParameter(PAGE_PARAM);
        String sizeStr = nativeWebRequest.getParameter(SIZE_PARAM);
        String[] sortStrArr = nativeWebRequest.getParameterValues(SORT_PARAM);

        if (pageStr != null) {
            pageStr = URLDecoder.decode(pageStr, "UTF-8");
        }
        if (sizeStr != null) {
            sizeStr = URLDecoder.decode(sizeStr, "UTF-8");
        }

        Integer page = null;
        Integer size = null;

        if (webDataBinderFactory != null) {
            //绑定page size参数
            WebDataBinder binder = webDataBinderFactory.createBinder(nativeWebRequest, null, methodParameter.getParameterName());
            page = binder.convertIfNecessary(pageStr, Integer.class);
            size = binder.convertIfNecessary(sizeStr, Integer.class);
        }

        // 判断是否可以为空，如果不能，使用注解中的默认值
        PageDefault annotation = methodParameter.getParameterAnnotation(PageDefault.class);
        if (!annotation.required()) {
            if (page == null) {
                page = annotation.page();
            }
            if (size == null) {
                size = annotation.size();
            }
            if (sortStrArr == null) {
                sortStrArr = annotation.sort();
            }
        } else {
            if (page == null || size == null) {
                throw new IllegalArgumentException("分页参数不能为空");
            }
        }


        List<Order> orders = new LinkedList<>();
        if (sortStrArr != null) {
            for (int i = 0; i < sortStrArr.length; i++) {
                sortStrArr[i] = URLDecoder.decode(sortStrArr[i], "UTF-8");
            }

            for (String sortStr : sortStrArr) {
                String[] split = sortStr.split(",");
                if (split.length != 2) {
                    continue;
                }
                Order.Direction direction = null;
                if (split[1].toUpperCase().equals(Order.Direction.ASC.name())) {
                    direction = Order.Direction.ASC;
                } else if (split[1].toUpperCase().equals(Order.Direction.DESC.name())) {
                    direction = Order.Direction.DESC;
                }
                if (direction != null) {
                    orders.add(new Order(split[0], direction));
                }
            }
        }

        // 绑定排序参数
        return new PageQuery(page, size, orders);

    }
}