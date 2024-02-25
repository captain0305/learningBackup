package com.captainx.learningBackup.并发.ThreadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/6
 * @Description:异步情况使用
 **/
public class TransmittableThreadLocalCompeletableFutureAsyncExample {
    private static final TransmittableThreadLocal<String> threadLocalVariable = new TransmittableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        // 在主线程中设置线程本地变量的值
        threadLocalVariable.set("com.captainx.learningBackup.Main Thread Value");

        // 使用线程池创建异步线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 异步任务1
        executorService.submit(() -> {
            // 在异步线程1中，可以访问到主线程设置的线程本地变量的值
            String value = threadLocalVariable.get();
            System.out.println("Async Thread 1 Value: " + value);

            // 修改异步线程1的本地变量值
            threadLocalVariable.set("Updated Value in Async Thread 1");

            // 调用另一个异步任务
            executorService.submit(() -> {
                // 在嵌套的异步线程中，可以访问到上一级异步线程设置的线程本地变量的值
                String nestedValue = threadLocalVariable.get();
                System.out.println("Nested Async Thread Value: " + nestedValue);
            });
        });

        Thread.sleep(500);
        // 异步任务2
        executorService.submit(() -> {
            // 在异步线程2中，线程本地变量的值是初始值，因为没有在当前线程中设置过
            String value = threadLocalVariable.get();
            System.out.println("Async Thread 2 Value: " + value);
        });

       Thread.sleep(1000);
        // 关闭线程池
        executorService.shutdown();



    }
}
