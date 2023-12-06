package com.captainx.learningBackup.设计模式.chapter3装饰模式.商场管理软件_简单工厂策略模式装饰模式;

public class CashNormal implements ISale {
    //正常收费，原价返回
    public double acceptCash(double price,int num){
        return price * num; 
    }    
}
