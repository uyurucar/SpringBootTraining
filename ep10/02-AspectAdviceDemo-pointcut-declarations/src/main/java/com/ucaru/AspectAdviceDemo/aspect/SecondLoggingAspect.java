package com.ucaru.AspectAdviceDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class SecondLoggingAspect {

    @Before("com.ucaru.AspectAdviceDemo.aspect.AopExpressions.allButGetterSetter()")
    public void secondFunctionBeforeAddAcc()
    {
        System.out.println("######## second call #######");
    }

}
