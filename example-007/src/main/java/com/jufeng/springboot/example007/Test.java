package com.jufeng.springboot.example007;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 19:53
 **/

@Getter
@Component
public class Test {


    @Value("${name}")
    private String name;


    @Value("${my.secret}")
    private String secret;

    @Value("${my.number}")
    private int  numberInt;
    @Value("${my.bignumber}")
    private  long bignumber;
    @Value("${my.uuid}")
    private String  uuid;

}
