package com.captainx.learningBackup.并发.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;


//底层通过reentrantlock来间接使用aqs实现condition
public class testCyclicBarrier {

    static CyclicBarrier c=new CyclicBarrier(2);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    c.await();
                } catch (Exception e){

                }
                System.out.println(1);
            }
        }).start();
        try{
            c.await();
        }catch (Exception e){

        }
        System.out.println(2);
    }
}
