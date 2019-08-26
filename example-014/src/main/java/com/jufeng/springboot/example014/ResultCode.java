package com.jufeng.springboot.example014;


/**
 * 返回code 表
 */
public enum ResultCode {
    // add by zhaojun
    Success(0),
    Unknown_error(1),
    Incorrect_signature(104),
    Page_not_found(404);

    private int value;

    ResultCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
    public String getString(){
        return this.toString();
    }

}