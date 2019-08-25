package com.jufeng.springboot.example010.controller;

import com.jufeng.springboot.example010.User;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-25 09:39
 **/
@RequestMapping("/user")
@RestController
public class UserController {

    /**
     * get 请求
     * @param name
     * @return
     */
    @GetMapping("/getUser/{name}")
    public User getUser(@PathVariable String name){
        User user = new User();
        user.setAge(28);
        user.setName(name);
        return user;
    }

    /**
     * post 请求
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return user;
    }

    /**
     * method 指定具体方法，不指定的话 ，都支持
     * @param age
     * @return
     */
    @RequestMapping(value = "selectUserAge",method = RequestMethod.GET)
    public User selectUserByAge(@RequestParam("age") int age){
        User user = new User();
        user.setAge(age);
        user.setName("jufeng");
        return user;
    }

}
