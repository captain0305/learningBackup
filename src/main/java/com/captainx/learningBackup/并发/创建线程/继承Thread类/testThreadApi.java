package com.captainx.learningBackup.并发.创建线程.继承Thread类;

public class testThreadApi {
    public static void main(String[] args) {
        Thread t1=new MyThread();
        t1.start();
       // System.out.println(t1.getName());

        Thread t2=new MyThread();
        t2.start();
       // System.out.println(t2.getName());

        Thread main = Thread.currentThread();
        System.out.println(main.getName());

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出"+i);
        }


    }
}
