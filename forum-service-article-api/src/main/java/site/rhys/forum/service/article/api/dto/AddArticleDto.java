package site.rhys.forum.service.article.api.dto;

import lombok.Data;
import site.rhys.forum.service.article.api.model.ContextType;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 18:51
 * @since 1.0.0
 */
@Data
public class AddArticleDto {

    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String context;

    /**
     * 内容类型
     */
    private ContextType contextType;

    /**
     * 分类id
     */
    private Long categoryId;

}
