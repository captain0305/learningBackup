package com.captainx.learningBackup.leetcode.toOffer01.day19_搜索与回溯6;
/*
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。



示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45
 */
public class sumNums {
    //神仙题
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }



}
