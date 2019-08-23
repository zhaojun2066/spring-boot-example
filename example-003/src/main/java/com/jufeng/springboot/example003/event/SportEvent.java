package com.jufeng.springboot.example003.event;

import com.jufeng.springboot.example003.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 18:03
 **/
@Getter
public class SportEvent extends ApplicationEvent {

    private User user;

    public SportEvent(Object source,User user) {
        super(source);
        this.user = user;
    }
}
