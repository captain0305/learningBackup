package com.captainx.learningBackup.leetcode.杂题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/14
 * @Description:3，30两个数输出330 leetcode 179
 **/
public class getLargest {
    public static void main(String[] args) {
        int int1 = 302;
        int int2 = 2;
        int[] nums=new int[]{1,3,455512,3213,2321};
        String[] strNums = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Integer[] array = Arrays.stream(nums).mapToObj(Integer::valueOf).toArray(Integer[]::new);
        Arrays.sort(array,new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return s1.compareTo(s2);
            }
        });
        Arrays.sort(strNums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });

        if (strNums[0].equals("0")){
            System.out.println(0);
            return;
        }
        String result = String.join("", strNums);

        System.out.println(result);
    }
}
