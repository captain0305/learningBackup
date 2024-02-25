package com.captainx.learningBackup.并发.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;


//底层通过reentrantlock来间接使用aqs实现condition
public class testCyclicBarrier {

    //有4个await线程同时在await才会执行后面步骤
    static CyclicBarrier c=new CyclicBarrier(4);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("Thread 1");
                    c.await();
                } catch (Exception e){

                }
                System.out.println(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("Thread 2");
                    c.await();
                } catch (Exception e){

                }
                System.out.println(2);
            }
        }).start();
        try{
            System.out.println("thread main");
            c.await();
        }catch (Exception e){

        }
        System.out.println(3);
    }
}
