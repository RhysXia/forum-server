package site.rhys.forum.service.article.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.pojo.Category;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.article.service.CategoryService;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 21:04
 */
@Api(tags = "文章分类api", description = "文章分类相关操作的api")
@ApiResponses({
        @ApiResponse(code = 200, message = "服务器进行了响应")
})
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取指定id的文章分类信息")
    @GetMapping("/{id:\\d+}")
    public ResultVo findById(@PathVariable("id") Long id) {

        Category category = categoryService.findById(id);
        if (category == null) {
            return ResultVo.fail("对应id的文章分类不存在");
        }
        return ResultVo.success("获取文章分类信息成功", category);
    }

}
