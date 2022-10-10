package com.analyticssakha;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(com..*)")
    public void AuthenticationPointCut(){

    }
    @Pointcut("within(com..*)")
    public void AuthorizationPointCut(){

    }

    @Before("AuthenticationPointCut() && AuthorizationPointCut()")
    public void Authentication(){
        System.out.println("Authenticating the request");
    }

}
