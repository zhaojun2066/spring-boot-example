package com.jufeng.springboot.example004;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 19:10
 **/
@Component
public class MyArg {

    @Autowired
    public MyArg(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs(); // 获取所有参数字符串，
        System.out.println(files); //[file=10.jpg, hello, word]
    }
}
