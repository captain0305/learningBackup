package 并发.Lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class testReentrantLock2 {
    @Test
    public void test(){
        // 创建一个非公平锁
        ReentrantLock unfairLock = new ReentrantLock();
        // 创建一个公平锁
        ReentrantLock fairLock = new ReentrantLock(true);


        // 启动多个线程并让它们竞争非公平锁
        Runnable unfairTask = () -> {
            for (int i = 1; i <= 5; i++) {
                unfairLock.lock();
                try {
                    System.out.println("Non-fair Lock - Thread " + Thread.currentThread().getId() + " acquired the lock.");
                } finally {
                    unfairLock.unlock();
                }
            }
        };

        // 启动多个线程并让它们竞争公平锁
        Runnable fairTask = () -> {
            for (int i = 1; i <= 5; i++) {
                fairLock.lock();
                try {
                    System.out.println("Fair Lock - Thread " + Thread.currentThread().getId() + " acquired the lock.");
                } finally {
                    fairLock.unlock();
                }
            }
        };

        // 创建多个线程并启动它们
        for (int i = 0; i < 5; i++) {
            Thread unfairThread = new Thread(unfairTask);
            Thread fairThread = new Thread(fairTask);
            unfairThread.start();
            fairThread.start();
        }
    }

    public static void main(String[] args) {
        // 创建一个非公平锁
        ReentrantLock unfairLock = new ReentrantLock();
        // 创建一个公平锁
        ReentrantLock fairLock = new ReentrantLock(true);

        // 启动多个线程并让它们竞争非公平锁
        Runnable unfairTask = () -> {
            for (int i = 1; i <= 5; i++) {
                unfairLock.lock();
                try {
                    System.out.println("Non-fair Lock - Thread " + Thread.currentThread().getId() + " acquired the lock.");
                } finally {
                    unfairLock.unlock();
                }
            }
        };

        // 启动多个线程并让它们竞争公平锁
        Runnable fairTask = () -> {
            for (int i = 1; i <= 5; i++) {
                fairLock.lock();
                try {
                    System.out.println("Fair Lock - Thread " + Thread.currentThread().getId() + " acquired the lock.");
                } finally {
                    fairLock.unlock();
                }
            }
        };

        // 创建多个线程并启动它们
        for (int i = 0; i < 5; i++) {
            //Thread unfairThread = new Thread(unfairTask);
            Thread fairThread = new Thread(fairTask);
            //unfairThread.start();
            fairThread.start();
        }
    }
}
