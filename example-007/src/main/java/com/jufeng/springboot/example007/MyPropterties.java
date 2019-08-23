package com.jufeng.springboot.example007;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 20:01
 **/
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "my")
public class MyPropterties {
    private String number;
}
