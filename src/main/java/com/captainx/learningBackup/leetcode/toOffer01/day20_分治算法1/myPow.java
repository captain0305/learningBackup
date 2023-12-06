package com.captainx.learningBackup.leetcode.toOffer01.day20_分治算法1;
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。



示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class myPow {
    public double myPow(double x, int n) {
        long b = n;
        if(b<0){
            x=1/x;
        }
        return calculate(x,b);
    }
    public double calculate(double x,long n){
        if(n == 0)  return 1;
        if(n == 1)  return x;
        double a = calculate(x,n/2);
        if(n % 2 == 0){
            return a * a;
        }
        return a * a * x;
    }
}
