package com.example.ordermanagement.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.ordermanagement.controller.CustomerController.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.ordermanagement.controller.CustomerController.*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        System.out.println("executed: " + joinPoint.getSignature().getName() + " | Return: " + result);
    }
}
