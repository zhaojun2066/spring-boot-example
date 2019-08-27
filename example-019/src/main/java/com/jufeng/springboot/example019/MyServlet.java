package com.jufeng.springboot.example019;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 10:39
 **/
@WebServlet(
        name = "MyServlet",
        displayName = "MyServlet",
        urlPatterns = "/index/my",
        initParams = {
                @WebInitParam(name = "name",value = "jufeng"),
                @WebInitParam(name = "age",value = "18")
        }
)
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("MyServlet= "+getInitParameter("name"));
        System.out.println("MyServlet= "+getInitParameter("age"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
