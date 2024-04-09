package com.captainx.learningBackup.异常处理;

/**
 * @Author: xuchengrui
 * @Date: 2024/4/9
 * @Description:试一下能否return
 **/
public class tryCatchFinally {
    public static void main(String[] args) {
        System.out.println(aBoolean());
    }

    public static boolean aBoolean(){
        try {
            throw new RuntimeException();
        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }
}
