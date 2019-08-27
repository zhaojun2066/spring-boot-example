package com.jufeng.springboot.example028;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stringRedisTemplate.opsForValue().set("hello","word");
        String value = stringRedisTemplate.opsForValue().get("hello");
        System.out.println(value);
    }
}