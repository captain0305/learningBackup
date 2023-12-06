package com.captainx.learningBackup.并发.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAllOfExample {
    public static void main(String[] args) {
        CompletableFuture<String> downloadFile1 = CompletableFuture.supplyAsync(() -> downloadFile("file1.txt"));
        CompletableFuture<String> downloadFile2 = CompletableFuture.supplyAsync(() -> downloadFile("file2.txt"));
        CompletableFuture<String> downloadFile3 = CompletableFuture.supplyAsync(() -> downloadFile("file3.txt"));

        CompletableFuture<Void> allDownloads = CompletableFuture.allOf(downloadFile1, downloadFile2, downloadFile3);

        allDownloads.thenRun(() -> {
            System.out.println("All files downloaded!");
            // 这里可以进行所有文件下载完成后的操作
            try {
                String result1 = downloadFile1.get();
                String result2 = downloadFile2.get();
                String result3 = downloadFile3.get();
                System.out.println("File 1 content: " + result1);
                System.out.println("File 2 content: " + result2);
                System.out.println("File 3 content: " + result3);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).join();//没有join阻塞输出结果会缺失

        // 主线程继续执行其他操作
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
