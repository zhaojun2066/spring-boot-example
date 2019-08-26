package com.jufeng.springboot.example018;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 16:17
 **/
public class AsyncCallableProcessor  implements CallableProcessingInterceptor {

    private static final ThreadLocal<String> contextHolders = new ThreadLocal<String>();

    //拦截callable 此时已经是callable当前的线程
    @Override
    public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
        //可以设置ThreadLocal 变量
        System.out.println("preProcess");
    }

    //callable 执行之后
    @Override
    public <T> void postProcess(NativeWebRequest request, Callable<T> task, Object concurrentResult) throws Exception {
        //删除ThreadLocal的变量
        System.out.println("postProcess");
    }



    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
        HttpServletRequest httpRequest = request.getNativeRequest(HttpServletRequest.class);
        return new CustomException(httpRequest.getRequestURI());
    }
}
