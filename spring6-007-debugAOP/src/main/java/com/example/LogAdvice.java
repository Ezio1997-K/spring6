package com.example;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LogAdvice {
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before Advice" + joinPoint.getSignature().getName());
    }
}
