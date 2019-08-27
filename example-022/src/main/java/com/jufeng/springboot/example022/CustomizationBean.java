package com.jufeng.springboot.example022;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 14:19
 **/
@Component
public class CustomizationBean  implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setContextPath("/index");
        factory.setPort(8989);
    }
}
