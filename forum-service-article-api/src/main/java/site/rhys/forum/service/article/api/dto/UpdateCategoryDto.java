package site.rhys.forum.service.article.api.dto;

import lombok.Data;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/15 18:51
 * @since 1.0.0
 */
@Data
public class UpdateCategoryDto {

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

}
