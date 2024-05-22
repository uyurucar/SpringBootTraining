package com.ucaru.AspectAdviceDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //optional
public class AopExpressions {

    //@Before("execution(public void addAccount())")
    //@Before("execution(* add*(..))")
    @Pointcut("execution(* com.ucaru.AspectAdviceDemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.ucaru.AspectAdviceDemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.ucaru.AspectAdviceDemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !( getter() || setter() )")
    public void allButGetterSetter() {}



}
