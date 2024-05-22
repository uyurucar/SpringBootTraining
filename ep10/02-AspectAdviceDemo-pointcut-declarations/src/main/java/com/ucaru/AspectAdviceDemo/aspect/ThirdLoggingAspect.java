package com.ucaru.AspectAdviceDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class ThirdLoggingAspect {

    @Before("com.ucaru.AspectAdviceDemo.aspect.AopExpressions.allButGetterSetter()")
    public void thirdFunctionBeforeAddAcc()
    {
        System.out.println("####### third call ########");
    }


}
