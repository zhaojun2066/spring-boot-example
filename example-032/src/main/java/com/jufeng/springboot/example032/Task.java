package com.jufeng.springboot.example032;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-28 15:15
 **/

@Slf4j
@Component
public class Task {

    // 指定 Executor 生成对应的bean
    @Async("asyncServiceExecutorA")
    public void run(){
        log.info("hello1");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("hello2");
    }
}
