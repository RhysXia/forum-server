package site.rhys.forum.support.spring.boot.starter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import site.rhys.forum.common.exception.IllegalArgumentException;
import site.rhys.forum.support.spring.boot.starter.vo.ErrorResultVo;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/14 11:07
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResultVo IllegalArgumentException(IllegalArgumentException e) {
        return new ErrorResultVo(e.getMessage());
    }
}
