package com.captainx.learningBackup.并发.ThreadLocal;


import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/6
 * @Description:TransmittableThreadLocal使用案例
 **/
public class TransmittableThreadLocalExample {
    //withInitial方法保证每个线程创建时，调用get方法都有初始值，不需要set
    private static final TransmittableThreadLocal<String> ttl=TransmittableThreadLocal.withInitial(()->new String("123"));

    public static void main(String[] args) {
        // 在主线程中设置线程本地变量的值
        ttl.set("com.captainx.learningBackup.Main Thread Value");

        // 创建一个新的线程
        Thread newThread = new Thread(() -> {
            // 在新线程中，可以访问到主线程设置的线程本地变量的值
            String value = ttl.get();
            System.out.println("Value in new thread: " + value);
        });

        // 启动新线程
        newThread.start();
    }
}
