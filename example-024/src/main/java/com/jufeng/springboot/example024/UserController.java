package com.jufeng.springboot.example024;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 14:37
 **/
@RestController
public class UserController {

    @GetMapping("/getName")
    public String getName(){
        return "jufeng";
    }
}
