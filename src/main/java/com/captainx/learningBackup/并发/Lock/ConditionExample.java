package com.captainx.learningBackup.并发.Lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//阻塞和等待的区别在于 阻塞是因为他人竞争不到锁引起 等待是自身需要等待其他线程进行一些操作引起
//condition.await()会释放当前的锁然后将当前线程加入到对应condition的等待队列的队尾
//condition.signal()会唤醒对应condition等待队列队头节点移到AQS同步队列的队尾
//移动到AQS同步队列后再通过lockSupport来唤醒该节点的线程让其脱离阻塞态有机会竞争锁
public class ConditionExample {
    private static final int CAPACITY = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == CAPACITY) {
                // 队列已满，等待消费者通知
                notFull.await();
            }
            queue.add(item);
            System.out.println("Produced: " + item);
            // 通知消费者队列非空
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                // 队列为空，等待生产者通知
                notEmpty.await();
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            // 通知生产者队列非满
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ConditionExample example = new ConditionExample();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    example.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int item = example.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

//        try {
//            producer.join();
//            consumer.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
    }
}
