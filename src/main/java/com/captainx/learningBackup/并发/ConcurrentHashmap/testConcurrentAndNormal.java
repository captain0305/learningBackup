package com.captainx.learningBackup.并发.ConcurrentHashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class testConcurrentAndNormal {
    public static void main(String[] args) throws InterruptedException {
        // 使用 HashMap 进行测试
        Map<Integer, Integer> hashMap = new HashMap<>();
        runTest(hashMap);

        // 使用 ConcurrentHashMap 进行测试
        Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        runTest(concurrentHashMap);
    }

    private static void runTest(Map<Integer, Integer> map) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, i);
            }
        };

        // 创建两个线程并行执行任务
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        // 等待两个线程执行完成
        thread1.join();
        thread2.join();

        // 输出 Map 的大小，观察不同的数据结构在多线程环境下的表现
        System.out.println("Map size: " + map.size());
    }
}
