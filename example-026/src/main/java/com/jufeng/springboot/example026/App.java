package com.jufeng.springboot.example026;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.jufeng.springboot.example026")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}