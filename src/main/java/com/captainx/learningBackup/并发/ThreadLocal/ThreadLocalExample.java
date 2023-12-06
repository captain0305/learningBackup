package com.captainx.learningBackup.并发.ThreadLocal;


//用于数据绑定来保证线程安全
//可以在保证线程安全的情况下不加锁提升效率
public class ThreadLocalExample {
    private static ThreadLocal<String> t1 = new ThreadLocal<>();
    private static ThreadLocal<String> t2 = new ThreadLocal<>();

    private String content;

    private String getContent(){
        String s=t1.get();
        return s;
    }
    private void setContent(String content){
        t1.set(content);
    }

    private String getContent2(){
        String s=t2.get();
        return s;
    }
    private void setContent2(String content){
        t2.set(content);
    }

    public static void main(String[] args) {
        ThreadLocalExample threadLocalExample=new ThreadLocalExample();
        for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    threadLocalExample.setContent(Thread.currentThread().getName()+"的first数据");
                    threadLocalExample.setContent2(Thread.currentThread().getName()+"的second数据");
                    System.out.println(Thread.currentThread().getName()+"--->"+threadLocalExample.getContent()+"   "+threadLocalExample.getContent2());
                    t1.remove();
                }
            };
            Thread thread=new Thread(task);
            thread.start();
        }



    }
}
