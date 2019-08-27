package com.jufeng.springboot.example020;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 11:25
 **/

@Configuration
public class Config {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new FirstFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("name","jufeng");
        bean.setOrder(3);
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new SecondFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("age","19");
        bean.setOrder(2);
        return bean;
    }

    @Bean
    public ServletRegistrationBean getServletBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new MyServlet());
        bean.setUrlMappings(Arrays.asList("/index/my"));
        bean.setInitParameters(new HashMap<String, String>(){{
            put("name","jufeng");
            put("age","18");
        }});
        return bean;
    }
}
