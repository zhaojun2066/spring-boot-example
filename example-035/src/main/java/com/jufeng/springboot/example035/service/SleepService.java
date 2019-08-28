package com.jufeng.springboot.example035.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-28 17:57
 **/
@Slf4j
public class SleepService implements ActiveService {
    @Override
    public void active() {
        log.info("active sleep...");
    }
}
