package com.aopexam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:SercurityLogAspect
 * Package:com.aopexam.aspect
 * Description:
 */
@Component
@Aspect
public class SercurityLogAspect {
    @Pointcut("execution(* com.aopexam.biz..save*(..))")
    public void savePointCut() {
    }

    @Pointcut("execution(* com.aopexam.biz..modify*(..))")
    public void modifyPointCut() {
    }

    @Pointcut("execution(* com.aopexam.biz..delete*(..))")
    public void deletePointCut() {
    }

    @Before("savePointCut()||deletePointCut()||modifyPointCut()")
    public void record(JoinPoint joinPoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("张三于" + sdf.format(new Date()) + "操作了" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }
}
