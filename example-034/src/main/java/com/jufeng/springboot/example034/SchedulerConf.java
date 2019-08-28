package com.jufeng.springboot.example034;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.boot.task.TaskSchedulerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-28 15:14
 **/

@Slf4j
@Configuration
@EnableScheduling
public class SchedulerConf {


    @Bean(name = "threadPoolTaskScheduler")
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(TaskSchedulerBuilder builder) {
        // 可以使用 TaskExecutorBuilder 进行创匠，springboot 会为我们自动创建 TaskExecutorBuilder
        log.info("start ThreadPoolTaskScheduler");
       return builder.poolSize(5)
                .threadNamePrefix("jufeng-sc-")
                .build();
    }


}
