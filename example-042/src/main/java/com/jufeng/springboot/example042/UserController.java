package com.jufeng.springboot.example042;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-30 16:33
 **/
@Controller
public class UserController {

    @RequestMapping("/index")
    public String getUser(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jufeng");


        User user = new User();
        user.setAge(18);
        user.setName("JF");
        model.addAttribute("user",user);
        return "index";
    }
}
