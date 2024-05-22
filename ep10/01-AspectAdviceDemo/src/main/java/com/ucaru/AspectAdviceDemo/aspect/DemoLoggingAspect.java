package com.ucaru.AspectAdviceDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    //@Before("execution(public void addAccount())")
    //@Before("execution(* add*(..))")
    @Before("execution(* com.ucaru.AspectAdviceDemo.*.*.*(..))")
    //@Before("execution(public void com.ucaru.AspectAdviceDemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n ######### @before on add*() #########");
    }

}
