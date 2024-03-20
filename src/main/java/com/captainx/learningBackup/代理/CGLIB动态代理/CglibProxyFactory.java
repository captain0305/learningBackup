package com.captainx.learningBackup.代理.CGLIB动态代理;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: xuchengrui
 * @Date: 2024/2/28
 * @Description:代理类工厂
 **/
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback((Callback) new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }

}
