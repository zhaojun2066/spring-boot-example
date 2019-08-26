package com.jufeng.springboot.example014;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


/**
 * @program: gateway
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-07-29 18:03
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {



    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleAllException(HttpServletRequest request,
                                       Exception ex) {
        // ex.printStackTrace();
        log.info("global exception: {} " , ex.getMessage() );
        return Response.choose(ResultCode.Unknown_error.getValue(),
                "Unknown error","未知错误");
    }

    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public Response handleBusinessException(HttpServletRequest request,
                                            Exception ex) {
        log.info("handleBusinessException exception: {} " , ex.getMessage() );
        return Response.choose(ResultCode.Unknown_error.getValue(),
                "Unknown error",ex.getMessage());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Response NoHandlerFoundException(HttpServletRequest request,
                                            NoHandlerFoundException ex) {
        log.info("handleBusinessException exception: {} " , ex.getMessage() );
        return Response.choose(ResultCode.Page_not_found.getValue(),
                "Page not found",ex.getMessage());
    }
}
