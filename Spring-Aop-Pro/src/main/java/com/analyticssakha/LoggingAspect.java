package com.analyticssakha;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.analyticssakha.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp){
        //System.out.println(jp.getSignature());
        String arg = jp.getArgs()[0].toString();
        System.out.println("Arguement: " + arg);
        System.out.println(jp.getSourceLocation());
        System.out.println("Before Logger method called");
    }

    @After("execution(* *.*.*.checkout(..))")
    public void afterLogger(){
        System.out.println("After Logger method called");
    }
}
