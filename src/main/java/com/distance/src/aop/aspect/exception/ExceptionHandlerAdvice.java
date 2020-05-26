package com.distance.src.aop.aspect.exception;


import com.distance.src.aop.aspect.NoahResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author 缄默
 * @date 2019/5/23
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public NoahResult handleException(Exception e) {
        log.error("小程序接口项目异常信息:{}",e);
        return NoahResult.builderFail("999", "系统异常");
    }

    @ExceptionHandler(NoahException.class)
    public NoahResult handleException(NoahException e) {
        log.error("小程序接口项目异常信息:{}",e);
        return NoahResult.builderFail(e.getCode(), e.getMessage());
    }

    /**
     * 拦截valid参数不匹配
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public NoahResult handleIllegalParamException(BindException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = "参数不合法";
        if (errors.size() > 0) {
            message = errors.get(0).getDefaultMessage();
        }
        log.error("小程序接口项目异常信息:{}",e);
        return NoahResult.builderFail("000", message);
    }

}
