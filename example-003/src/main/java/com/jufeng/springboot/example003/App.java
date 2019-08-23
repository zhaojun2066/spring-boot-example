package com.jufeng.springboot.example003;

import com.jufeng.springboot.example003.publish.PublishEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private PublishEvent publishEvent;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Jufeng");
        user.setPassword("5555555555");
        publishEvent.publish(user);

        publishEvent.pushSayEvent("hello");

        System.out.println("调用完成");
    }
}