package com.captainx.learningBackup.leetcode.toOffer01.day24_数学2;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void testListToArray(){
        int target=9;
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        int[][] ints = res.toArray(new int[0][]);
        //toArray(new T[0])能够运行是因为java做了优化，能动态生成对应大小的数组，是官方建议的书写方式，能避免某些并发问题并且效率更高
        for (int i1 = 0; i1 < ints.length; i1++) {
            for (int i2 = 0; i2 < ints[i1].length; i2++) {
                System.out.println(ints[i1][i2]);
            }
        }

    }

    @Test
    public void testIntList(){
        List<int[]> res = new ArrayList<>();
        //List<int> res1=new ArrayList<>();
        List<Integer> res2=new ArrayList<>();
    }

    @Test
    public void testIntList2(){
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        System.out.println(res.get(0));
        res.remove(0);
        System.out.println(res.get(0));
    }
}
