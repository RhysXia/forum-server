package site.rhys.forum.support.spring.boot.starter.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.common.vo.ResultVo;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/14 11:07
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResultVo<Void> IllegalArgumentException(IllegalArgumentException e) {
        return ResultVo.create(ResultVo.CODE_PARAM_ERROR, e.getMessage(), null);
    }
}
