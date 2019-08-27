package com.jufeng.springboot.example026;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 14:37
 **/
@RestController
public class AdController {

    @Autowired
    private AdService adService;
    @GetMapping("/getList")
    public List<Ad> getName(){
        return adService.getList();
    }
}
