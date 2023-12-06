package com.captainx.learningBackup.单元测试Mock;

/**
 * @Author: xuchengrui
 * @Date: 2023/11/23
 * @Description:静态测试类
 **/
public class MyStaticClass {
    private String aa="123";
    public static String staticMethod() {
        return "Original Static Method";
    }



    private String myPrivate(){
        return this.aa;
    }

    public String getAa(){
        return myPrivate();
    }
}
