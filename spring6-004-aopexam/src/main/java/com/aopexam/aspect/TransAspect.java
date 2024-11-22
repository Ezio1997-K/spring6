package com.aopexam.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ClassName:TransAspect
 * Package:com.aopexam.aspect
 * Description:
 *
 */
@Aspect
@Component
public class TransAspect {
    @Around("execution(* com.aopexam.service..*(..))")
    public void aroundTrans(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("开启事务");


            joinPoint.proceed();
            System.out.println("关闭事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }
}
