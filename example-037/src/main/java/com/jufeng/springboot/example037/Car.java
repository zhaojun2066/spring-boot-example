package com.jufeng.springboot.example037;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-29 09:27
 **/
@Slf4j
public class Car {

    private int horsepower; //马力
    private int displacement; // 排量
    private int cylinders;// 气缸数

    public Car() {
    }

    public Car(int horsepower, int displacement, int cylinders) {
        this.horsepower = horsepower;
        this.displacement = displacement;
        this.cylinders = cylinders;
    }

    public void driver(){
        log.info("马力： {} | 排量：{}L | V{}，超强动力",this.horsepower,this.displacement,this.cylinders);
    }
}
