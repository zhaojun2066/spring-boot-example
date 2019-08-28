package com.jufeng.springboot.example035;

import com.jufeng.springboot.example035.service.ActiveService;
import com.jufeng.springboot.example035.service.SleepService;
import com.jufeng.springboot.example035.service.SportService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-28 17:58
 **/
@Configuration
public class Conf {

    @Bean
    @Conditional(SleepCondition.class)
    public ActiveService createSleep(){
        return new SleepService();
    }

    @Bean
    @Conditional(SportCondition.class)
    public ActiveService createSport(){
        return new SportService();
    }
}
