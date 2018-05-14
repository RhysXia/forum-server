package site.rhys.forum.common.exception;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/14 11:03
 * @since 1.0.0
 * <p>
 * 已经存在实体异常
 */
public class ExistEntityException extends ServiceException {

    public ExistEntityException(String message) {
        super(message);
    }

    public ExistEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
