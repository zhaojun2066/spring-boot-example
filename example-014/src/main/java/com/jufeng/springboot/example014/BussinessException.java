package com.jufeng.springboot.example014;

/**
 * @program: gateway
 * @description: 自定义异常类
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-07-29 18:10
 **/
public class BussinessException extends  RuntimeException {
    private static final long serialVersionUID = 5012744468450606818L;
    public BussinessException(String message) {
        super(message);
    }
}
