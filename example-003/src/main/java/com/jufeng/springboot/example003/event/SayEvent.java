package com.jufeng.springboot.example003.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 18:29
 **/

@Getter
public class SayEvent extends ApplicationEvent {

    private String say;

    public SayEvent(Object source, String say) {
        super(source);
        this.say =say;
    }
}
