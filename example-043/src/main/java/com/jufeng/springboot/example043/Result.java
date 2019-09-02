package com.jufeng.springboot.example043;

import lombok.Data;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-09-02 10:26
 **/
@Data
public class Result<T> {
    private String code;
    private T data;
    private String msg;
}
