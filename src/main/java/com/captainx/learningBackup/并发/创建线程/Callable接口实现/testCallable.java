package com.captainx.learningBackup.并发.创建线程.Callable接口实现;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class testCallable {
    public static void main(String[] args) throws Exception{
        Callable<Integer> myCallable=new MyCallable();
        //futuretask实现了runnable接口
        FutureTask<Integer> f1=new FutureTask<>(myCallable);
        new Thread(f1).start();

        Integer integer = f1.get();
        System.out.println(integer);
    }
}
