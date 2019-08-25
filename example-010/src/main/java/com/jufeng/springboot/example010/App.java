package com.jufeng.springboot.example010;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        /**
         * 自定义SpringApplication
         */
        SpringApplication.run(App.class, args);

    }




}