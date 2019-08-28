package com.jufeng.springboot.example034;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
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
    @Scheduled(cron = "*/5 * * * * ? ")
    public void run(){
        log.info("hello1");
    }

    @Scheduled(cron = "*/2 * * * * ? ")
    public void run2(){
        log.info("hello2");
    }
}
