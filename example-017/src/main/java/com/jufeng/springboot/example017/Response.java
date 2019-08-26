package com.jufeng.springboot.example017;

import lombok.Data;

/**
 * @program: gateway
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-07-29 17:56
 **/

@Data
public class Response {
    private Integer code;
    private String msg;
    private Object o;
}
