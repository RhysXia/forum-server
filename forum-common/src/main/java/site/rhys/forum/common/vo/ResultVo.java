package site.rhys.forum.common.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-18 18:00
 * 响应结果
 */
@Getter
@Setter
public class ResultVo<T> {
    //结果码
    public static final int CODE_SUCCESS = 200;

    public static final int CODE_PARAM_ERROR = 400;


    /**
     * 返回码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;


    public static <T> ResultVo<T> create(int code, String message, T data) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(code);
        resultVo.setData(data);
        resultVo.setMessage(message);
        return resultVo;
    }

    public static <T> ResultVo<T> success(String message, T data) {
        return create(ResultVo.CODE_SUCCESS, message, data);
    }

}
