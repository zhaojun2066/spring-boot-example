package com.jufeng.springboot.example018;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 14:23
 **/
@RestController
public class UserController {

    @GetMapping("/getUser")
    public Callable<User> getUser(){
        return () -> {
            User user = new User();
            user.setName("jufeng");
            System.out.println("getUsering...");
            return user;
        };
    }
}
