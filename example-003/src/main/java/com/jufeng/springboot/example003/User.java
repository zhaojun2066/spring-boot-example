package com.jufeng.springboot.example003;

import lombok.Data;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-23 18:07
 **/
@Data
public class User {
    //用户名
    private String name;
    //密码
    private String password;
}
