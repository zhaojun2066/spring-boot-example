package com.jufeng.springboot.example040;

import com.jufeng.springboot.example039.Car;
import com.jufeng.springboot.example039.EnableCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableCar
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private Car car;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        car.driver();
    }
}