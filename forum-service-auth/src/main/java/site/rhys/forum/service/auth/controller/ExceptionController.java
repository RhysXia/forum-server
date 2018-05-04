package site.rhys.forum.service.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.common.vo.ResultVo;

/**
 * <p>Company: www.rhys.site</p>
 *
 * @author : Rhys Xia
 * @version :1.0
 * @since : 2018-05-04 20:18
 */
@ControllerAdvice
@RestController
@Slf4j
public class ExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResultVo illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        log.info(ex.getMessage());
        return ResultVo.fail(ex.getMessage());
    }
}
