package site.rhys.forum.service.article.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.page.PageDefault;
import site.rhys.forum.common.page.PageQuery;
import site.rhys.forum.common.pojo.Article;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.article.service.ArticleService;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 21:04
 */
@Api(tags = "文章api", description = "文章相关操作的api")
@ApiResponses({
        @ApiResponse(code = 200, message = "服务器进行了响应")
})
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "获取指定id的文章信息")
    @GetMapping("/{id:\\d+}")
    public ResultVo findById(@PathVariable("id") Long id) {

        Article article = articleService.findById(id);
        if (article == null) {
            return ResultVo.fail("对应id的文章不存在");
        }
        return ResultVo.success("获取文章信息成功", article);
    }

    @ApiOperation(value = "分页查询文章列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "查询页", defaultValue = "1", required = false, dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示数", defaultValue = "10", required = false, dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序方式", required = false, dataType = "array", paramType = "query", example = "sort=field1,DESC")
    })
    @GetMapping
    public ResultVo findByPage(@PageDefault(required = false) PageQuery pageQuery) {
        return null;
    }

}
