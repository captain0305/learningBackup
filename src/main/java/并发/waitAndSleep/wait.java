package 并发.waitAndSleep;

import java.util.TreeMap;

public class wait {
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        new Thread(()->{
            synchronized(lock){
                try{
                    System.out.println("wait之前");
                    lock.wait();
                    System.out.println("wait之后");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(100);
        System.out.println("执行notify");
        synchronized (lock){
            lock.notify();
        }
    }
}
