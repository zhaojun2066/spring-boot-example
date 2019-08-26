package com.jufeng.springboot.example018;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 16:19
 **/
public class CustomException extends RuntimeException {

    public CustomException(String msg){
        super(msg);
    }
}