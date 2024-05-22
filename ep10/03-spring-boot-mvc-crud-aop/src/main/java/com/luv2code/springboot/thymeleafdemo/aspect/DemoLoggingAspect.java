package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // set up logger

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..) )")
    private void controllerPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..) )")
    private void servicePackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..) )")
    private void daoPackage() {}

    @Pointcut("controllerPackage() || servicePackage() || daoPackage()")
    private void anyPackage() {}

    @Before("anyPackage()")
    public void before(JoinPoint joinPoint)
    {
        //display called method
        logger.info("###### before ###### "+ joinPoint.getSignature().toShortString() + " #");

        //display arguments
        Object[] args = joinPoint.getArgs();

        for(Object arg : args)
        {
            logger.info("###### before ###### argument: " + arg  + " #");
        }

    }

    @AfterReturning(pointcut = "anyPackage()", returning = "result")
    public void after(JoinPoint joinPoint, Object result)
    {
        //display returned method
        logger.info("###### after ###### "+ joinPoint.getSignature().toShortString() + " #");

        if(result instanceof List) System.out.println("## list: " + result + " #");
        //display data returned
        logger.info("###### after  ###### result: "+ result+ " #");
    }


}
