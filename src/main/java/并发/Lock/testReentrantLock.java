package 并发.Lock;



import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testReentrantLock {
    public static void main(String[] args) {
        // 非公平锁示例
        //15151515 16161616 减少线程切换的调度
        ReentrantLock nonFairLock = new ReentrantLock();
        Runnable nonFairTask = () -> {
            for (int i = 1; i <= 5; i++) {
                nonFairLock.lock();
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " acquired the lock.");
                    Thread.sleep(100); // 模拟线程执行一些工作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    nonFairLock.unlock();
                }
            }
        };

        // 创建多个线程并启动它们
        Thread nonFairThread1 = new Thread(nonFairTask);
        Thread nonFairThread2 = new Thread(nonFairTask);
        nonFairThread1.start();
        nonFairThread2.start();

        // 公平锁示例
        //15 16 15 16 15 16按队列执行
        ReentrantLock fairLock = new ReentrantLock(true);
        Runnable fairTask = () -> {
            for (int i = 1; i <= 5; i++) {
                fairLock.lock();
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " acquired the fair lock.");
                    Thread.sleep(100); // 模拟线程执行一些工作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fairLock.unlock();
                }
            }
        };

        // 创建多个线程并启动它们
        Thread fairThread1 = new Thread(fairTask);
        Thread fairThread2 = new Thread(fairTask);
        fairThread1.start();
        fairThread2.start();
    }


}
