package com.captainx.learningBackup.代理.CGLIB动态代理;

/**
 * @Author: xuchengrui
 * @Date: 2024/2/28
 * @Description:模拟发短信类
 **/
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    public static void sendStatic(String message){
        System.out.println("static message"+message);
    }

}
