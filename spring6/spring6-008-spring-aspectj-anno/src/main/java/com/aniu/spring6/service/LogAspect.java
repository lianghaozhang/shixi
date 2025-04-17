package com.aniu.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LogAspect {

    // 通用切点，实现切点表达式的复用
    @Pointcut("execution(void com.aniu.spring6.service.UserService.getUserList(..))")
    public void 通用切点(){}

    // 前置通知
    @Before("通用切点()")
    public void beforeAdvice(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("前置通知");
    }

    // 后置通知
    @AfterReturning("通用切点()")
    public void afterReturningAdvice() {
        System.out.println("后置通知");
    }

    // 环绕通知
    @Around("通用切点()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知-前环绕");
        joinPoint.proceed();
        System.out.println("环绕通知-后环绕");
    }

    // 异常通知
    @AfterThrowing("execution(void com.aniu.spring6.service.UserService.getUserList(..))")
    public void afterThrowingAdvice() {
        System.out.println("异常通知");
    }

    // 最终通知
    @After("execution(void com.aniu.spring6.service.UserService.getUserList(..))")
    public void afterAdvice() {
        System.out.println("最终通知");
    }

}
