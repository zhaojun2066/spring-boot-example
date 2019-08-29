package com.jufeng.springboot.example039;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: spring-boot-example
 * @description: 汽车引擎
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-29 09:22
 **/

@Data
@ConfigurationProperties(prefix="car")
public class EngineProperties {

    private int horsepower; //马力
    private int displacement; // 排量
    private int cylinders;// 气缸数

}
