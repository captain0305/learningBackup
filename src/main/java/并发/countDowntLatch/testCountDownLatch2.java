package 并发.countDowntLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class testCountDownLatch2 {
    static CountDownLatch c=new CountDownLatch(3);
    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(2);
                c.countDown();
            }
        }).start();
        //永久阻塞
        //c.await();
        //定时阻塞

        c.await(3, TimeUnit.SECONDS);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
                c.countDown();
            }
        }).start();

        c.await();
        System.out.println("finish");
    }
}
