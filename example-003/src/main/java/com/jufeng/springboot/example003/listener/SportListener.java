package com.jufeng.springboot.example003.listener;

import com.jufeng.springboot.example003.event.SportEvent;
import com.jufeng.springboot.example003.User;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-example
 * @description: 注解方式实现监听
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 18:10
 **/
@Component
public class SportListener {


    @Async // 支持异步
    @EventListener
    public void sportList(SportEvent sportEvent){
        try {
            //故意阻塞3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = sportEvent.getUser();
        System.out.println(user.toString() + " from  @EventListener  阻塞三秒后执行");
    }
}
