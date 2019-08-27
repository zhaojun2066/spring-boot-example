package com.jufeng.springboot.example026;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 16:22
 **/
@Data
@Entity
@Table(name = "litemall_ad")
public class Ad {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
