package com.jufeng.springboot.example026;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 16:12
 **/
public interface AdDao    extends JpaRepository<Ad,Long> {
    public List<Ad> findByName(String name);
}
