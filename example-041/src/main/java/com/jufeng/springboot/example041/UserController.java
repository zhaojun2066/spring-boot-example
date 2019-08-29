package com.jufeng.springboot.example041;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-29 10:49
 **/

@RestController
public class UserController {

    @GetMapping("/getName")
    public String getName(){
        return "JuFeng";
    }
}
