package 并发.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/6
 * @Description: inheritableThreadLocal使用案例--实现父子线程的数据传递
 **/
public class InheritableThreadLocalExample {
    // 定义一个 InheritableThreadLocal 变量
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        // 设置主线程的本地变量
        inheritableThreadLocal.set("Main Thread Value");

        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorServiceSon = Executors.newFixedThreadPool(2);

        // 启动子线程1
        executorService.submit(() -> {
            // 子线程1会继承父线程的本地变量
            System.out.println("Thread 1: " + inheritableThreadLocal.get());
            executorServiceSon.submit(()->{
                System.out.println("Thread 1's son:"+inheritableThreadLocal.get());
            });
        });

        // 启动子线程2
        executorService.submit(() -> {
            // 子线程2会继承父线程的本地变量
            System.out.println("Thread 2: " + inheritableThreadLocal.get());
            executorServiceSon.submit(()->{
                System.out.println("Thread 2's son:"+inheritableThreadLocal.get());
            });
        });

        // 关闭线程池
        executorService.shutdown();
    }
}
