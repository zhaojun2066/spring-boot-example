package com.jufeng.springboot.example009;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        /**
         * 自定义SpringApplication
         */
        SpringApplication application = new SpringApplication();
        application.run(App.class, args);

    }
}