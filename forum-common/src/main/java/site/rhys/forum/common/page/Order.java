package site.rhys.forum.common.page;

import lombok.Getter;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-06 20:11
 */
public class Order {

    /**
     * 排序字段
     */
    @Getter
    private String field;

    /**
     * 排序方式
     */
    @Getter
    private Direction direction;


    public Order(String field, Direction direction) {
        this.direction = direction;
        this.field = field;
    }

    /**
     * 排序方向
     */
    public enum Direction {
        /**
         * 降序
         */
        DESC,

        /**
         * 升序
         */
        ASC
    }
}
