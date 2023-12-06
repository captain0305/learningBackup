package com.captainx.learningBackup.并发.银行线程安全模拟;

public class ThreadTest {
    public static void main(String[] args) {
        Account acc=new Account("ICBC-1000",100000);
        new DrawThread(acc,"小红").start();
        new DrawThread(acc,"小明").start();
    }
}
