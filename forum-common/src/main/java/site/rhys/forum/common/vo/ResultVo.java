package site.rhys.forum.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 20:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAIL = 400;
    private int code;
    private String message;
    private Object data;

    public static ResultVo create(int code, String message, Object data) {
        return new ResultVo(code, message, data);
    }

    public static ResultVo success(String message, Object data) {
        return create(ResultVo.CODE_SUCCESS, message, data);
    }

    public static ResultVo success(String message) {
        return success(message, null);
    }

    public static ResultVo fail(String message) {
        return create(ResultVo.CODE_FAIL, message, null);
    }

}
