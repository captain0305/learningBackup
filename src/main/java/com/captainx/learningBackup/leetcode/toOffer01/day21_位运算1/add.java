package com.captainx.learningBackup.leetcode.toOffer01.day21_位运算1;
/*
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。



示例:

输入: a = 1, b = 1
输出: 2
 */


/*
思路可以将加法拆分成  非进位和s+进位c
然后通过循环当进位 c等于0时 结果就为s
s=a^b
c=a&b<<1
 */

public class add {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
