package com.captainx.learningBackup.代理.CGLIB动态代理;

import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;


/**
 * @Author: xuchengrui
 * @Date: 2024/2/28
 * @Description:自定义方法拦截器
 **/
public class DebugMethodInterceptor implements MethodInterceptor {

    /**
            * @param o           被代理的对象（需要增强的对象）
            * @param method      被拦截的方法（需要增强的方法）
            * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return object;
    }


}
