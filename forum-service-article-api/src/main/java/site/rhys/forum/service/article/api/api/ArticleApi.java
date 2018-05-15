package site.rhys.forum.service.article.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import site.rhys.forum.service.article.api.dto.AddArticleDto;
import site.rhys.forum.service.article.api.dto.UpdateArticleDto;
import site.rhys.forum.service.article.api.model.Article;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:15
 * @since 1.0.0
 */
@Api(tags = "文章api", description = "文章相关操作的api")
@RequestMapping("/articles")
public interface ArticleApi {


    @ApiOperation(value = "分页查询文章")
    @GetMapping
    Page<Article> findAll(@PageableDefault Pageable pageable);


    @ApiOperation(value = "根据作者id查询文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true, paramType = "path", dataType = "long"),
    })
    @GetMapping
    Page<Article> findAllByAuthorId(@RequestParam("authorId") Long authorId,
                                    @PageableDefault Pageable pageable);


    @ApiOperation(value = "分页查询分类下的文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类的id", required = true, paramType = "path", dataType = "long"),

    })

    @GetMapping
    Page<Article> findAllByCategoryId(@RequestParam("categoryId") Long categoryId,
                                      @PageableDefault Pageable pageable);


    @ApiOperation(value = "根据文章id查找文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章的id", required = true, paramType = "path", dataType = "long")
    })
    @GetMapping("/{id}")
    Article findById(@PathVariable("id") Long id);

    @ApiOperation(value = "添加文章,返回成功后的id")
    @PostMapping
    Long add(@RequestBody AddArticleDto article);


    @ApiOperation(value = "修改文章非空字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章的id", required = true, paramType = "path", dataType = "long"),
    })
    @PutMapping(value = "/{id}", params = "all=false")
    void updateSelectionById(@PathVariable("id") Long id,
                             @RequestBody UpdateArticleDto article);

    @ApiOperation(value = "删除文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章的id", required = true, paramType = "path", dataType = "long")
    })
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);

    @ApiOperation(value = "根据分类id删除文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类的id", required = true, paramType = "query", dataType = "long")
    })
    @DeleteMapping
    void deleteAllByCategoryId(@RequestParam("categoryId") Long categoryId);
}
