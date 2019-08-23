package com.jufeng.springboot.example003.publish;

import com.jufeng.springboot.example003.event.SayEvent;
import com.jufeng.springboot.example003.event.SportEvent;
import com.jufeng.springboot.example003.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 18:13
 **/
@Component
public class PublishEvent {
    @Autowired
    private ApplicationEventPublisher applicationContext;


    public void publish(User user){
        applicationContext.publishEvent(new SportEvent(this,user));
    }

    public void pushSayEvent(String say){
        applicationContext.publishEvent(new SayEvent(this,say));
    }
}
