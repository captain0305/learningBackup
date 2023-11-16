package 并发.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


//底层有一个内部抽象类继承实现aqs接口
public class testSemaphore {
    private static final int THREAD_COUNT=30;
    private static ExecutorService threadPoll= Executors.newFixedThreadPool(THREAD_COUNT);

    //10表示允许10个线程获取许可证，使用完后调用release()方法归还许可证，没获取到的线程处于阻塞状态

    //tryAcquire()方法在没有获取许可的情况下会立即返回false,尝试获取许可证的线程不会被阻塞
    private static Semaphore s=new Semaphore(10);

    public static void main(String[] args) {
        //30个线程共10个许可证
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPoll.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    }catch (Exception e){

                    }
                }
            });
        }
        threadPoll.shutdown();
    }
}
