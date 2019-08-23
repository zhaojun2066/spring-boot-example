package com.jufeng.springboot.example003.listener;

import com.jufeng.springboot.example003.event.SayEvent;
import com.jufeng.springboot.example003.publish.PublishEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 18:33
 **/
@Component
public class SayWordLister implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        //只有SayEvent监听类型才会执行下面逻辑
        return aClass == SayEvent.class;
    }

    /**
     * @param aClass
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        //只有在PublishEvent内发布的事件时才会执行下面逻辑
        return aClass == PublishEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //转换事件类型
        SayEvent sayEvent = (SayEvent) applicationEvent;
        //获取注册用户对象信息
        String say = sayEvent.getSay();
        System.out.println("说话 ："+say+"  two");
    }

    /**
     * 同步情况下监听执行的顺序，越小指向约靠前
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
