package com.captainx.learningBackup.并发.Async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/6
 * @Description:异步任务编排
 **/
@Service
public class AsyncClient {

    @Autowired
    private AsyncService myAsyncService;

    public void performAsyncTasks() {
        // 触发异步方法1
        CompletableFuture<String> future1 = myAsyncService.asyncMethod1();
        // 在异步方法1执行完成后触发异步方法2
        CompletableFuture<String> future2 = myAsyncService.asyncMethod2("我的方法");

        Thread main=Thread.currentThread();
        // 处理异步方法1的结果
        future1.thenAccept(result1 -> System.out.println("Result from Async Method 1: " + result1+"in thread:"+main.getName()));

        // 处理异步方法2的结果
        future2.thenAccept(result2 -> System.out.println("Result from Async Method 2: " + result2+"in thread:"+main.getName()));

        // 主线程逻辑
        System.out.println("com.captainx.learningBackup.Main thread continues its work...");

        // 等待所有的任务完成
        CompletableFuture.allOf(future1, future2).join();
    }
}
