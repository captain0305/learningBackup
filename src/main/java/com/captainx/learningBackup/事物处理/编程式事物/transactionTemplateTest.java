package com.captainx.learningBackup.事物处理.编程式事物;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Time;

@Slf4j
public class transactionTemplateTest {
    @Test
    public void test1(){
        Time time = Time.valueOf("11:23:44");
        System.out.println(time);

        Time time2 = Time.valueOf("1699252274303");

        System.out.println(time2);
    }

    @Test

    public void test2(){
        String a=null;
        System.out.println("".equals(a));

    }

    @Test
    public void test3(){
        Integer a=null;

        System.out.println(a!=null&&a==773574);

    }
}
