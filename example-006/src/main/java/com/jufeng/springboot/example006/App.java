package com.jufeng.springboot.example006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.run(App.class, args);
        System.exit(0);// 模拟 kill pid
    }
}