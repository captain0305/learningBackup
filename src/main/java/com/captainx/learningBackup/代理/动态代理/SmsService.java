package com.captainx.learningBackup.代理.动态代理;

public interface SmsService {
    String send(String message);

    static String send2(String message) {
        return message;
    }

}
