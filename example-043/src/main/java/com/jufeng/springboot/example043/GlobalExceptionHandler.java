package com.jufeng.springboot.example043;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @program: spring-boot-example
 * @description: 统一异常处理
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-09-02 10:23
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class,
            MethodArgumentNotValidException.class,
            ServletRequestBindingException.class,
            BindException.class }/*,
            HttpMessageNotReadableException.class}*/)
    @ResponseStatus(value = HttpStatus.OK)
    public Result<?> handleValidationException(Exception e) {
        String msg = "";
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException t = (MethodArgumentNotValidException) e;
            msg = getBindingResultMsg(t.getBindingResult());
        } else if (e instanceof BindException) {
            BindException t = (BindException) e;
            msg = getBindingResultMsg(t.getBindingResult());
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException t = (ConstraintViolationException) e;
            msg = t.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(","));
        } else if (e instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException t = (MissingServletRequestParameterException) e;
            msg = t.getParameterName() + " 不能为空";
        } else if (e instanceof MissingPathVariableException) {
            MissingPathVariableException t = (MissingPathVariableException) e;
            msg = t.getVariableName() + " 不能为空";
        }/*else if (e instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException t = (HttpMessageNotReadableException) e;
            msg =  t.getMessage();
        } */else {
            msg = "必填参数缺失";
        }
        log.warn("参数校验不通过,msg: {}", msg);
        Result result = new Result();
        result.setCode("0001");
        result.setMsg(msg);
        return result;
    }

    private String getBindingResultMsg(BindingResult result) {
        return result.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
    }


    /**
     * 统一处理业务异常
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleBusinessException(Exception t) {
        Result result = new Result();
        result.setCode("0001");
        result.setMsg(t.getMessage());
        return result;
    }
}
