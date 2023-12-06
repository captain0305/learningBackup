package com.captainx.learningBackup.leetcode.toOffer01.day24_数学2;
/*
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */

//用动态规划dp进行解决
public class cuttingRope {
    public int cuttingRope(int n) {
        // f(0)=1,f(1)=1,f(2)=1*1,f(3)=2
        //n小于等于3的情况
        if (n <= 3) {
            return Math.max(n - 1, 1);
        }
        // dp思路：砍成两段的最大乘积是 f(n) = f(x)*f(n-x)
        // f(2)虽然=1，在计算的时候的等于2，比如4=2*2=4,不能是1*1
        // f(3)虽然=2，在计算的时候的等于3，比如6=3*3=9,不能是2*2
        // 也就是说在dp计算的时候,f(x)的最小值只能是x,不能小于x
        // 在x>=4的时候计算出来都是大于x,所以不需要特殊定义
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int ans = 1;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                ans = Math.max(ans, f[j] * f[i - j]);//总和为最大的ans或者f[j] * f[i - j]
            }
            f[i] = ans;
            ans = 0;
        }
        return f[n];
    }
}
