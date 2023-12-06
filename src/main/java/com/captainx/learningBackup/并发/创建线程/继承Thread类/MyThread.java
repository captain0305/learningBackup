package com.captainx.learningBackup.并发.创建线程.继承Thread类;

public class MyThread extends Thread{
    @Override
    public void run() {
        Thread t=Thread.currentThread();
        String name = t.getName();
        for (int i = 0; i < 6; i++) {
            System.out.println(name+i);
        }
    }
}
