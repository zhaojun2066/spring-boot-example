package com.jufeng.springboot.example008;

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

    @Value("${age}")
    private int age;
}
