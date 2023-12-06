package com.captainx.learningBackup.常用数据结构以及工具类.Random;

import org.junit.Test;

import java.util.Random;

public class RandomTest {
    @Test
    public void test1(){
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            //产生0-2直接的随机数
            System.out.println(random.nextInt(3));
        }

    }

    @Test
    public void test2(){
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(0));
        }

    }
}
