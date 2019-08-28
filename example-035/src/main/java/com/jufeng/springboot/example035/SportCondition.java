package com.jufeng.springboot.example035;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-08-28 17:55
 **/
public class SportCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String status = context.getEnvironment().getProperty("status");
        if ("sport".equals(status)){
            return true;
        }
        return false;
    }
}
