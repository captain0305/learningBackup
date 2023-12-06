package com.captainx.learningBackup.设计模式.chapter2策略模式.商场管理软件简单工厂和策略模式;

public class CashNormal extends CashSuper {

    //正常收费，原价返回
    public double acceptCash(double price,int num){
        return price * num;
    }
    
}
