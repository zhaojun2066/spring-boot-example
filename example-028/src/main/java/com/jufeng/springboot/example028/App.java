package com.jufeng.springboot.example028;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("hello","word");
        String value = (String) redisTemplate.opsForValue().get("hello");
        redisTemplate.delete("hello");
        System.out.println(value);
         value = (String) redisTemplate.opsForValue().get("hello");
        System.out.println("=="+value);
    }
}