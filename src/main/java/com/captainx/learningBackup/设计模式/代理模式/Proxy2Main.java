package com.captainx.learningBackup.设计模式.代理模式;

import java.util.Random;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/21
 * @Description:火星车地面指挥台代理模式实现
 **/
public class Proxy2Main {

    public static void main(String[] args) {
        Car car=new Car();
        Contorller contorller=new Contorller();
        car.setContorller(contorller);

        for (int i = 0; i < 10; i++) {
            car.move();
        }

    }
}

interface Movings{
    void move();

    void takePhoto();

}

 interface Callback {
    void takePhotoCompleted();

    void moveCompleted();

     void takePhotoFail();

     void moveFail();
}

class Contorller implements Movings,Callback{

    @Override
    public void move() {
        System.out.println("控制台移动指令");
    }

    @Override
    public void takePhoto() {
        System.out.println("控制台拍照指令");
    }

    @Override
    public void takePhotoCompleted() {
        System.out.println("控制台拍照指令完成");
    }
    @Override
    public void moveCompleted() {
        System.out.println("控制台移动指令完成");
    }

    @Override
    public void takePhotoFail() {
        System.out.println("控制台拍照指令失败");
    }

    @Override
    public void moveFail() {
        System.out.println("控制台移动指令失败");
    }
}
class Car implements Movings,Callback{
    public void setContorller(Contorller contorller) {
        this.contorller = contorller;
    }

    private Contorller contorller;

    @Override
    public void move() {
        System.out.println("探险车移动");
        contorller.move();
        Random random=new Random();
        if (random.nextBoolean()){
            moveCompleted();
            contorller.moveCompleted();
        }else {
            moveFail();
            contorller.moveFail();
        }
    }

    @Override
    public void takePhoto() {
        System.out.println("探险车拍照");
        contorller.takePhoto();
        Random random=new Random();
        if (random.nextBoolean()){
            takePhotoCompleted();
            contorller.takePhotoCompleted();
        }else {
            takePhotoFail();
            contorller.takePhotoFail();
        }
    }

    @Override
    public void takePhotoCompleted()  {
        System.out.println("探险车拍照完成");
    }

    @Override
    public void moveCompleted() {
        System.out.println("探险车移动完成");
    }

    @Override
    public void takePhotoFail() {
        System.out.println("探险车拍照失败");
    }

    @Override
    public void moveFail() {
        System.out.println("探险车移动失败");
    }


}
