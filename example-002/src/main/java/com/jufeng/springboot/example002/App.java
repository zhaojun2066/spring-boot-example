package com.jufeng.springboot.example002;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        /**
         * 自定义SpringApplication
         */
        SpringApplication application = new SpringApplication();

        //变成的方式，实现Banner 接口即可
        /*application.setBanner((environment, sourceClass, out) -> {
            out.println("hellooooooo");
        });*/
        application.run(App.class, args);

    }
}