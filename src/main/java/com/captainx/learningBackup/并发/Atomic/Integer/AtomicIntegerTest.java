package com.captainx.learningBackup.并发.Atomic.Integer;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/25
 * @Description:测试AtomicInteger功能
 **/
public class AtomicIntegerTest {

    private final ThreadFactory factory=new ThreadFactoryBuilder().setNameFormat("my-thread-poll-%d").build();
    private final ExecutorService executorService=new ThreadPoolExecutor(0,10,10L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1024),factory,new ThreadPoolExecutor.CallerRunsPolicy());


   public void testAtomicInteger(){
       AtomicInteger atomicInteger=new AtomicInteger(0);
       for (int i = 0; i < 100000; i++) {
           executorService.submit(()->{
              addAtomicInteger(atomicInteger);
               System.out.println(atomicInteger.get()+" "+Thread.currentThread().getName());
           });
       }
       System.out.println(atomicInteger.get());
   }

   private void addAtomicInteger(AtomicInteger atomicInteger){
       atomicInteger.getAndAdd(1);
       //atomicInteger.incrementAndGet();
   }

    public static void main(String[] args) {
        AtomicIntegerTest atomicIntegerTest=new AtomicIntegerTest();
        atomicIntegerTest.testAtomicInteger();
    }
}
