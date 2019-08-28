package com.jufeng.springboot.example036;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-28 18:17
 **/
@Configuration
public class Conf {

    /**
     * 这个方法要是放在createStudent() 之后，会有问题，
     * 如果使用@ConditionalOnBean注解依赖的Bean是通过配置类触发解析的，则执行结果依赖配置类加载顺序
     * 所以 ConditionalOnBean ，就是 只有 OnBean 在想实例化bean之前被扫描才可以
     *  如果改为 ConditionalOnClass ，就和bean 扫描顺序无关了，spring 扫描bean 先扫描 Compent, Controller Service，
     *  最后解析 @Configuration 配置的bean，按照配置顺序解析
     * @return
     */
    @Bean
    public Classz createClassz(){
        Classz classz = new Classz();
        return classz;
    }

    @Bean
    @ConditionalOnBean(Classz.class)
    public Student createStudent(Classz classz){
        Student student = new Student();
        student.setClassz(classz);
        return student;
    }


}
