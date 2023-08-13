package 代理.动态代理;

import 代理.动态代理.SmsService;

public class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message:"+ message);
        return message;
    }
}
