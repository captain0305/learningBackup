package com.captainx.learningBackup.AOP.staticAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: xuchengrui
 * @Date: 2024/2/27
 * @Description:aop
 **/
@Aspect
public class AspectMyStatic {

    @Before("@annotation(com.captainx.learningBackup.AOP.staticAop.staticBefore)")
    public void beforeMyStaticMethodCall() {
        System.out.println("Before calling myStaticMethod");
    }
}
