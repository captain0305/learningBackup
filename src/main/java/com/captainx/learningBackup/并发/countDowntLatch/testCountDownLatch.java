package com.captainx.learningBackup.并发.countDowntLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class testCountDownLatch {
    static CountDownLatch c=new CountDownLatch(3);
    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        //永久阻塞
        //c.await();
        //定时阻塞
        c.await(10, TimeUnit.SECONDS);
        System.out.println(3);
    }
}
