package com.ucaru.AspectAdviceDemo.aspect;

import com.ucaru.AspectAdviceDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(1)
@Component
public class DemoLoggingAspect {


    @Around("execution(* com.ucaru.AspectAdviceDemo.service.*.get*(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        Object result = null;
        //print method
        System.out.println("###around#### method signature: " + proceedingJoinPoint.getSignature());
        //get timestamp
        long begin = System.currentTimeMillis();
        //execute
        try {
            result = proceedingJoinPoint.proceed();
            //get end-timestamp
            System.out.println("object: " + result.getClass());
        } catch (Exception e) {
            System.out.println("######around##### exception occurred: " + e.getMessage());
            throw e;
        }
        long end = System.currentTimeMillis();

        //compute duration and print

        long duration = end - begin;

        System.out.println("#######around###### duration : " + duration/1000.0 + " #");

        return result;
    }


    @After("execution(* com.ucaru.AspectAdviceDemo.dao.AccountDAO.find*(..))")
    public void afterFinallyDaoAdvice(JoinPoint joinPoint)
    {
        System.out.println("###after(finally)#### method signature: " + joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "execution(* com.ucaru.AspectAdviceDemo.dao.AccountDAO.find*(..))", throwing = "exc")
    public void afterThrowingDaoAdvice(JoinPoint joinPoint, Throwable exc)
    {
        //print signature
        System.out.println("####### method signature: " + joinPoint.getSignature().toShortString());
        //log exception
        System.out.println("####### exception: " + exc);

    }


    @AfterReturning(pointcut = "execution(* com.ucaru.AspectAdviceDemo.dao.AccountDAO.find*(..))", returning = "result")
    public void AfterReturningDaoAdvice(JoinPoint joinPoint, List<Account> result)
    {
        //print signature
        System.out.println("###after_returning#### method signature: " + joinPoint.getSignature());
        //modify results
        if(!result.isEmpty())
        {
            for (Account acc : result)
            {
                String toUpper = acc.getName().toUpperCase();
                acc.setName(toUpper);
            }
        }
    }


    @Before("com.ucaru.AspectAdviceDemo.aspect.AopExpressions.forDaoPackage()")
    //@Before("execution(public void com.ucaru.AspectAdviceDemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint)
    {
        System.out.println("\n######### first call for @before on add*() #########");

        //display method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("signature: " + signature);

        //display method args
        Object[] args = joinPoint.getArgs();

        for(Object arg : args)
        {
            System.out.println(arg);
            if(arg instanceof Account)
            {
                //downcast
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }


    }





}
