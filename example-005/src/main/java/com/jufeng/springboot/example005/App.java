package com.jufeng.springboot.example005;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App  implements CommandLineRunner {
    public static void main(String[] args) {
        System.out.println("开始");
        SpringApplication.run(App.class, args);
        System.out.println("结束");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SpringApplication.run(.) 完成之前调用，此时bean 已经初始化完成了");
    }

    @Bean
    public CommandLineRunner init() {
      return args -> {
          System.out.println("SpringApplication.run(.) 完成之前调用，此时bean 已经初始化完成了22222");
      };
    }
}