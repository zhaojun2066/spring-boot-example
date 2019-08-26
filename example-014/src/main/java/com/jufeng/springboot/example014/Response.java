package com.jufeng.springboot.example014;

import lombok.Data;

/**
 * @program: gateway
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-07-29 17:56
 **/

@Data
public class Response {
    private Integer code;
    private String error;
    private String msg;
    private String description;


    public static Response unknowResonse(){
        return Response.choose(ResultCode.Unknown_error.getValue(),
                "Unknown error","未知错误");
    }


    public static Response success(){
        return Response.choose(ResultCode.Success.getValue(),
                "success","success");
    }

    public static Response signError(){
        return Response.choose(ResultCode.Incorrect_signature.getValue(),
                "Incorrect signature","签名无效");
    }


    public static Response choose(Integer code, String msg, String desc) {
        Response errorResponse = new Response();
        errorResponse.setCode(code);
        errorResponse.setMsg(msg);
        errorResponse.setDescription(desc);
        return errorResponse;
    }

    public static Response choose(Integer code, String msg, String desc,String error) {
        Response errorResponse = new Response();
        errorResponse.setCode(code);
        errorResponse.setMsg(msg);
        errorResponse.setDescription(desc);
        errorResponse.setError(error);
        return errorResponse;
    }
}
