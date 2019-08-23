package com.jufeng.springboot.example003.listener;

import com.jufeng.springboot.example003.event.SportEvent;
import com.jufeng.springboot.example003.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-example
 * @description: 实现 ApplicationListener 接口方式，发生 直接调用 onApplicationEvent 方法
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 18:10
 **/
@Component
public class SportApplicationListener implements ApplicationListener<SportEvent> {

    public void sportList(SportEvent sportEvent){
        User user = sportEvent.getUser();
        System.out.println(user.toString() + " from ApplicationListener");
    }

    @Override
    public void onApplicationEvent(SportEvent sportEvent) {
        this.sportList(sportEvent);
    }
}
