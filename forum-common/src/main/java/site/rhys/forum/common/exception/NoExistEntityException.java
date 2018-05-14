package site.rhys.forum.common.exception;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/14 11:03
 * @since 1.0.0
 * <p>
 * 不存在对应实体异常
 */
public class NoExistEntityException extends ServiceException {

    public NoExistEntityException(String message) {
        super(message);
    }

    public NoExistEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
