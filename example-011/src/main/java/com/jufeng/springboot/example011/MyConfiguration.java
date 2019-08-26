package com.jufeng.springboot.example011;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.Arrays;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 09:22
 **/

@Configuration
public class MyConfiguration {

    /**
     * @return
     */
    @Bean
    public HttpMessageConverters converters(){
        MyHttpMessageConverter converter = new MyHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        return new HttpMessageConverters(converter);
    }
}
