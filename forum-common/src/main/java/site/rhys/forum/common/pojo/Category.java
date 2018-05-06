package site.rhys.forum.common.pojo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 20:52
 * <p>
 * 文章分类
 */
@Data
public class Category {

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 排序字段,越小排序越靠后
     */
    private Integer orderNum;

    /**
     * 所属用户id
     */
    private Long userId;

    /**
     * 分类的描述信息
     */
    private String description;

    /**
     * 分类下的文章数
     */
    private Long articleCount;
}
