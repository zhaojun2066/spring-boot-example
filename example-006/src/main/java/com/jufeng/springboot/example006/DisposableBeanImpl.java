package com.jufeng.springboot.example006;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 19:24
 **/
@Component
public class DisposableBeanImpl implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println(" spring 容器正在等待销毁...1");
        System.out.println(" spring 容器正在等待销毁...2");
        System.out.println(" spring 容器正在等待销毁...3");
        System.out.println(" spring 容器正在等待销毁...4");
        System.out.println(" spring 容器正在等待销毁...5");
    }
}
