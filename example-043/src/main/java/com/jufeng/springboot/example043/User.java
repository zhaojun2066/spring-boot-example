package com.jufeng.springboot.example043;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-30 16:40
 **/

public class User implements Serializable {

    @NotBlank(message = "姓名不能空")
    @Length(min=2,max = 10,message =   "姓名长度在2 到10 之间")
    private String name;

    @NotNull(message = "年龄不能空")
    @Min(value = 1,message = "年龄应大于1岁")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
