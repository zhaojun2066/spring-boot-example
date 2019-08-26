package com.jufeng.springboot.example013;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: spring-boot-example
 * @description:  改变 SpringBoot的默认异常处理映射为“/error”
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 14:06
 **/

@RestController
public class MainsiteErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * JSON格式错误信息
     */
    @RequestMapping(value = "/error",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseMessage error(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> body = this.errorAttributes.getErrorAttributes(new ServletWebRequest(request), true);
        return ResponseMessage.fail("服务器端异常！", body);
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
