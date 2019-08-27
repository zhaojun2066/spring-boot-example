package com.jufeng.springboot.example026;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-27 16:22
 **/
@Service
public class AdService {

    @Autowired
    private AdDao adDao;

    public List<Ad> getList(){
        return adDao.findAll();
    }

    public List<Ad> findByName(String name){
        return adDao.findByName(name);
    }
}
