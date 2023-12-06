package com.captainx.learningBackup.并发.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {public static void main(String[] args) {
    // 模拟获取供应商的商品价格的异步操作
    //supplyAsync是创建带有返回值的异步任务
    CompletableFuture<Double> supplier1Price = CompletableFuture.supplyAsync(() -> getSupplierPrice("Supplier 1"));
    CompletableFuture<Double> supplier2Price = CompletableFuture.supplyAsync(() -> getSupplierPrice("Supplier 2"));
    CompletableFuture<Double> supplier3Price = CompletableFuture.supplyAsync(() -> getSupplierPrice("Supplier 3"));

    // 使用 thenCombine 方法组合 CompletableFuture，计算总价格
    CompletableFuture<Double> totalPrice = supplier1Price
            .thenCombine(supplier2Price, (price1, price2) -> price1 + price2)
            .thenCombine(supplier3Price, (total, price3) -> total + price3);

    try {
        // 等待计算完成并获取结果
        double finalPrice = totalPrice.get();
        System.out.println("Total price: " + finalPrice);
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
}

    // 模拟获取供应商的商品价格
    private static Double getSupplierPrice(String supplierName) {
        // 模拟耗时操作
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 返回随机价格
        return Math.random() * 100;
    }
}
