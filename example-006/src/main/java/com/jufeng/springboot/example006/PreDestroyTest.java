package com.jufeng.springboot.example006;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 19:34
 **/
@Component
public class PreDestroyTest {


    @PreDestroy
    public void destory(){
        System.out.println("@PreDestroy....");
    }
}
