package com.jufeng.springboot.example019;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 11:10
 **/
@Slf4j

@Order(2)
@WebFilter(filterName = "firstIndexFilter",
        displayName = "firstIndexFilter",
        urlPatterns = {"/index/my"},
        initParams = @WebInitParam(
                name = "firstIndexFilterInitParam",
                value = "com.jufeng.springboot.example019.filter.FirstFilter"))
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter.init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter.doFilter...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter.destroy...");
    }
}
