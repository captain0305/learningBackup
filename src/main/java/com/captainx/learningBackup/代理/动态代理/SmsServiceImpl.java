package com.captainx.learningBackup.代理.动态代理;

public class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message:"+ message);
        return message;
    }
}
