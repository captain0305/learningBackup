package com.captainx.learningBackup.并发.ThreadLocal;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/6
 * @Description:simpleformat使用
 **/
public class ThreadLocalExample2 {
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        int i=0;
        while (i<10) {
            new Thread(() -> {
                String dateStr = f.format(new Date());
                try {
                    Date parseDate = f.parse(dateStr);
                    String dateStrCheck = f.format(parseDate);
                    boolean equals = dateStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(equals + " " + dateStr + " " + dateStrCheck);
                    } else {
                        System.out.println(equals);
                    }
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }).start();
            i++;
        }
    }

}
