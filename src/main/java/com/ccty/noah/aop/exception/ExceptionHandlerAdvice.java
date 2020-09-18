package com.ccty.noah.aop.exception;


import com.ccty.noah.aop.NoahResult;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
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
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public NoahResult handleException(Exception e) {
        log.error("系统异常信息:{}",e);
        return NoahResult.builderFail("999", e.getMessage());
    }

    @ExceptionHandler(NoahException.class)
    public NoahResult handleException(NoahException e) {
        log.error("系统异常信息:{}",e);
        return NoahResult.builderFail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public NoahResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("校验失败", e);
        List<String> errors = Lists.newArrayList();
        e.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errors.add(fieldError.getDefaultMessage());
        });
        return NoahResult.builderFail("000", errors);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public NoahResult constraintViolationExceptionHandler(ConstraintViolationException e) {
        List<String> errors = Lists.newArrayList();
        log.error("系统异常", e);
        e.getConstraintViolations().forEach((constraintViolation) -> {
            errors.add(constraintViolation.getMessage());
        });
        return NoahResult.builderFail("000", errors);
    }

    /**
     * 拦截valid参数不匹配
     * @param e
     * @return
     */
    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public NoahResult bindExceptionHandler(BindException e) {
        log.error("系统异常", e);
        List<String> errors = Lists.newArrayList();
        e.getAllErrors().forEach((objectError) -> {
            errors.add(objectError.getDefaultMessage());
        });
        return NoahResult.builderFail("000", errors);
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus
    public Object defaultErrorHandler(Throwable ex, HttpServletResponse response) throws Exception {
        log.warn("请求异常", ex);
        int count = 0;
        Throwable base = ex;
        while(true) {
            ++count;
            if (count > 100 || base == null) {
                break;
            }
            if (base instanceof NoahException) {
                return NoahResult.builderFail(((NoahException)base).getCode(), ((NoahException)base).getMessage());
            }
            if (base == base.getCause()) {
                break;
            }
            base = base.getCause();
        }

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return NoahResult.builderFail("000", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        log.warn("请求异常", ex);
        String message = "参数[" + ex.getName() + "]格式错误！";
        return NoahResult.builderFail("000", message);
    }

    @ResponseBody
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        log.warn("请求异常", ex);
        String message = "参数[" + ex.getParameterName() + "]为必填！";
        return NoahResult.builderFail("000", message);
    }

    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object missingServletRequestParameterExceptionHandler(HttpMessageNotReadableException ex) {
        log.warn("请求异常", ex);
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException e = (InvalidFormatException)ex.getCause();
            if (e.getPath().size() > 0) {
                List<String> errors = Lists.newArrayList();
                e.getPath().forEach((reference) -> {
                    errors.add(reference.getFieldName());
                });
                return NoahResult.builderFail("000", "参数[" + errors + "]格式错误！");
            }
        }
        return NoahResult.builderFail("000", "未知错误！");
    }

}
