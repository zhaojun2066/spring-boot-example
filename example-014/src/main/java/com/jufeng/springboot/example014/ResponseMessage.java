package com.jufeng.springboot.example014;

import lombok.Data;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-26 14:09
 **/
@Data
public class ResponseMessage {
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回文字
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public ResponseMessage() {
    }

    public ResponseMessage(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回方法
     * @param data 返回数据
     */
    public static ResponseMessage success(Object data){
        return new ResponseMessage(true, null, data);
    }

    /**
     * 失败返回方法--默认
     */
    public static ResponseMessage fail(){
        return new ResponseMessage(false, null, null);
    }

    /**
     * 失败返回方法
     * @param message 文字信息
     */
    public static ResponseMessage fail(String message){
        return new ResponseMessage(false, message, null);
    }

    /**
     * 失败返回方法
     * @param message 文字信息
     * @param data 数据
     */
    public static ResponseMessage fail(String message, Object data){
        return new ResponseMessage(false, message, data);
    }
}
