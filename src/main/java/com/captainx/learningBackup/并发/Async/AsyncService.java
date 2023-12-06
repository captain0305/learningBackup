package com.captainx.learningBackup.并发.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/6
 * @Description:使用async注解
 **/
@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> asyncMethod1() {
        // 异步执行的方法逻辑
        System.out.println("Async method 1 executed in thread: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture("Result from Async Method 1");
    }

    @Async
    public CompletableFuture<String> asyncMethod2(String input) {
        // 异步执行的方法逻辑
        System.out.println("Async method 2 executed in thread: " + Thread.currentThread().getName() + ", with input: " + input);
        return CompletableFuture.completedFuture("Result from Async Method 2");
    }
}
