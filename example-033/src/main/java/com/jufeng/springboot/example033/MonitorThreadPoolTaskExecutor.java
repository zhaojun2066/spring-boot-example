package com.jufeng.springboot.example033;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;


/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-28 16:28
 **/

@Slf4j
@Component
public class MonitorThreadPoolTaskExecutor {

    @Autowired
    @Qualifier("asyncServiceExecutorA")
    private ThreadPoolTaskExecutor threadPoolExecutor;

    /**
     * 直接打印出来
     */
    public void monitor(){
        log.info("{}, taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                threadPoolExecutor.getThreadNamePrefix(),
                threadPoolExecutor.getThreadPoolExecutor().getTaskCount(),
                threadPoolExecutor.getThreadPoolExecutor().getCompletedTaskCount(),
                threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getThreadPoolExecutor().getQueue().size());
    }

}
