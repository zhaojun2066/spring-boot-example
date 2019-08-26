package com.jufeng.springboot.example017;

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
    public User getUser(){
        User user = new User();
        user.setName("jufeng");
        return user;
    }
}
