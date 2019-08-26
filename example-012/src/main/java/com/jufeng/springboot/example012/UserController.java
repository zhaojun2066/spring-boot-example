package com.jufeng.springboot.example012;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 10:14
 **/
@RestController
public class UserController {


    @GetMapping("/user/getUser")
    public User getUser(){
        User user = new User();
        user.setName("jufeng");
        user.setAge(19);
        return user;
    }

    @PostMapping("/user/addUser")
    public User addUser(@RequestBody  User user){
        return user;
    }
}
