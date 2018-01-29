package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//@Aspect
@Component
public class LogInterceptorAop {

//    @Before("execution(public void com.example.impl.UserDAOImpl.save(com.example.model.User))")
    //@Before("execution(public * com.example.impl.*.*(..))")
   // @Before("myMethod()")
    public void beforeMethod() {
       System.out.println("start");
    }

    //@AfterReturning("execution(public * com.example.impl.*.*(..))")
   // @AfterReturning("myMethod()")
    public void afterMethod() {
       System.out.println("end");
    }

    //@Pointcut("execution(public * com.example.impl.*.*(..))")
    public void myMethod() {

    };

    //@AfterThrowing("myMethod()")
    public void throwMethod() {
        System.out.println("throw");
    }

    //@Around("myMethod()")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //start
        System.out.println("around start");
        proceedingJoinPoint.proceed();
        //end
        System.out.println("around end");
    }

    }
