package site.rhys.forum.service.article.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.rhys.forum.service.article.api.model.Article;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:15
 * @since 1.0.0
 */
@Api(tags = "文章api", description = "文章相关操作的api")
public interface ArticleApi {

    @ApiOperation(value = "根据文章id查找文章")
    @GetMapping("/articles/{id:\\d+}")
    Article findById(@PathVariable("id") Long id);
}
