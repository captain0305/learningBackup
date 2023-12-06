package com.captainx.learningBackup.并发.创建线程.Callable接口实现;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Mycallable"+i);
        }
        return 1024;
    }
}
