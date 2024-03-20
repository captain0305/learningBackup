package com.captainx.learningBackup.AOP.staticAop;

/**
 * @Author: xuchengrui
 * @Date: 2024/2/27
 * @Description:静态方法类
 **/
public class MyClass {
    @staticBefore
    public static void myStaticMethod() {
        System.out.println("Inside myStaticMethod");
    }
}