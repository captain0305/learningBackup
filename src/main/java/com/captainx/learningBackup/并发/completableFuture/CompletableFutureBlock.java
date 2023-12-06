package com.captainx.learningBackup.并发.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureBlock {
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] commentList = new String[3];
        List<CompletableFuture> list=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                String s = downloadFile("file"+finalI+".txt");
                commentList[finalI] = s;
            }, executor);
            list.add(future);
        }
        System.out.println(CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()])).get());//调用get方法会阻塞主线程直到所有任务都完成ss

    }
    private static String downloadFile(String filename) {
        // 模拟文件下载过程
        try {
            Thread.sleep(2000); // 假设下载一个文件需要2秒
            System.out.println("下载文件"+filename);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Content of " + filename;
    }
}
