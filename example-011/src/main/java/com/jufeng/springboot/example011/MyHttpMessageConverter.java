package com.jufeng.springboot.example011;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 09:50
 **/
public class MyHttpMessageConverter extends AbstractHttpMessageConverter<User> {


    /**
     * 判断该转换器是否能将请求内容转换成Java对象
     * @param aClass
     * @param mediaType
     * @return
     */
    @Override
    public boolean canRead(Class aClass, MediaType mediaType) {
        return super.canRead(aClass, mediaType);
    }

    /**
     * 判断该转换器是否可以将Java对象转换成返回内容
     * @param aClass
     * @param mediaType
     * @return
     */
    @Override
    public boolean canWrite(Class aClass, MediaType mediaType) {
        return super.canWrite(aClass, mediaType);
    }



    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * 请求的时候 会调用
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = inputMessage.getBody();// 获得输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")); // 实例化输入流，并获取网页代码
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = reader.readLine()) != null) {
            sb.append(s);
        }
        reader.close();
        String str = sb.toString();
        User user = JSONObject.parseObject(str,User.class);
        return user;
    }

    /**
     * 响应的时候 会调用
     * @param user
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String us  = user.toString();
        byte[] bytes=us.getBytes("utf-8");
        outputMessage.getBody().write(bytes,0,bytes.length);
    }


}
