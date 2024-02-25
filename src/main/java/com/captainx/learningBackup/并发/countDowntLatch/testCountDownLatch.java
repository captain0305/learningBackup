package com.captainx.learningBackup.并发.countDowntLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class testCountDownLatch {
    //减不到0 c.await()之后不执行
    static CountDownLatch c=new CountDownLatch(4);
    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
                System.out.println(3);
                c.countDown();
            }
        }).start();
        //永久阻塞
        //c.await();
        //定时阻塞
        c.await();
        System.out.println(3);
    }
}
