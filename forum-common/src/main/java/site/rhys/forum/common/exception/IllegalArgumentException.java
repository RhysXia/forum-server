package site.rhys.forum.common.exception;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/14 11:03
 * @since 1.0.0
 *
 * 参数不合法异常
 */
public class IllegalArgumentException extends ServiceException{

    public IllegalArgumentException(String message) {
        super(message);
    }

    public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
