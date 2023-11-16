package 网络io.bio.伪异步bio线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerSocketServerPool {
    private ExecutorService executorService;

    /**
     * 创建这个类对象时初始化线程池
     */

    public HandlerSocketServerPool(int maxThreadNum, int queueSize){
        executorService=new ThreadPoolExecutor(3,maxThreadNum,120, TimeUnit.SECONDS
                ,new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable target){
        executorService.execute(target);
    }
}
