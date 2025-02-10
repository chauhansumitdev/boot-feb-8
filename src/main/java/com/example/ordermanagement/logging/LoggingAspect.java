package com.example.ordermanagement.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.ordermanagement.controller.CustomerController.*(..))")
    public void logBeforeCustomer(JoinPoint joinPoint) {
        System.out.println("called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.ordermanagement.controller.CustomerController.*(..))", returning = "result")
    public void logAfterCustomer(JoinPoint joinPoint, Object result) {
        System.out.println("executed: " + joinPoint.getSignature().getName() + " | Return: " + result);
    }

    @Before("execution(* com.example.ordermanagement.controller.AddressController.*(..))")
    public void logBeforeAddress(JoinPoint joinPoint) {
        System.out.println("called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.ordermanagement.controller.AddressController.*(..))", returning = "result")
    public void logAfterAddress(JoinPoint joinPoint, Object result) {
        System.out.println("executed: " + joinPoint.getSignature().getName() + " | Return: " + result);
    }


    @Before("execution(* com.example.ordermanagement.controller.OrderController.*(..))")
    public void logBeforeOrder(JoinPoint joinPoint) {
        System.out.println("called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.ordermanagement.controller.OrderController.*(..))", returning = "result")
    public void logAfterOrder(JoinPoint joinPoint, Object result) {
        System.out.println("executed: " + joinPoint.getSignature().getName() + " | Return: " + result);
    }

    @Before("execution(* com.example.ordermanagement.controller.ProductController.*(..))")
    public void logBeforeProductJoinPoint(JoinPoint joinPoint, Object result) {
        System.out.println("called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.ordermanagement.controller.ProductController.*(..))", returning = "result")
    public void logAfterProduct(JoinPoint joinPoint, Object result) {
        System.out.println("executed: " + joinPoint.getSignature().getName() + " | Return: " + result);
    }
}
