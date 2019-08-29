package com.jufeng.springboot.example039;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @program: spring-boot-example
 * @description: 相当于使用定义spring.factories完成Bean的自动装配
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-29 10:17
 * @Inherited  该annotation 修饰了一个类，子类也是会被修饰的
 **/

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CarAutoAutoConfiguration.class)
public @interface EnableCar {
}
