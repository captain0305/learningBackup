package com.captainx.learningBackup.代理.CGLIB动态代理;

/**
 * @Author: xuchengrui
 * @Date: 2024/2/28
 * @Description:入口
 **/
public class Main {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");


    }
}
