package com.jufeng.springboot.example043;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-30 16:33
 **/
@Validated
@RestController
public class UserController {

    @RequestMapping("/add")
    public User getUser(  @Valid @NotNull(message = "User is null") @RequestBody User user){
        User userq = new User();
        userq.setAge(18);
        userq.setName("JF");
        return userq;
    }
}
