package com.captainx.learningBackup.并发.创建线程.Runnable接口实现;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyRunnable"+i);
        }
    }
}
