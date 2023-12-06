package com.captainx.learningBackup.leetcode.代码随想录.字符串;


import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class test {
    @Test
    public void test(){
        String s="abab";
        lo:
        for (int i = 0; i < s.length()-1; i++) {
            boolean res=false;
            if(s.length()%(i+1)==0){
                lo1:
                for (int j = 0; j < s.length()/(i+1)-1; j++) {
                    if(!s.substring(j*(i+1),(j+1)*(i+1)).equals(s.substring((j+1)*(i+1),(j+2)*(i+1)))){
                        res=s.substring(j*(i+1),(j+1)*(i+1)).equals(s.substring((j+1)*(i+1),(j+2)*(i+1)));
                        break lo1;
                    } else if (s.substring(j*(i+1),(j+1)*(i+1)).equals(s.substring((j+1)*(i+1),(j+2)*(i+1)))) {
                        res=s.substring(j*(i+1),(j+1)*(i+1)).equals(s.substring((j+1)*(i+1),(j+2)*(i+1)));
                    }
                }
            }


        }


    }

    @Test
    public void test1(){
        PriorityQueue<Integer> a=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        a.add(3);
        a.add(2);
        a.add(6);
        System.out.println(a);
        System.out.println(a.peek());
        System.out.println(a.poll());
        System.out.println(a);

    }
}
