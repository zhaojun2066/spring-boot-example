package com.jufeng.springboot.example013;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 14:23
 **/
@RestController
public class UserController {

    @GetMapping("/getUser")
    public String getUser(){
        throw new RuntimeException("hello haha");
    }
}
