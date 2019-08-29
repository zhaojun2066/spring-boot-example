package com.jufeng.springboot.example039;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-example
 * @description: 汽车自动化配置
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-29 09:21
 **/
@Configuration
@EnableConfigurationProperties(EngineProperties.class)
@ConditionalOnClass(Car.class)
@ConditionalOnProperty(prefix = "car", matchIfMissing = true, value = "enabled")
public class CarAutoAutoConfiguration {

    @Autowired
    private EngineProperties engineProperties;

    @Bean
    @ConditionalOnMissingBean(Car.class) // 没有情况就会实例化
    public Car car(){
        Car car = new Car(engineProperties.getHorsepower(),engineProperties.getDisplacement(),engineProperties.getCylinders());
        return car;
    }
}
