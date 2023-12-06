package com.captainx.learningBackup.leetcode.toOffer01.day10_动态规划3;
/*
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class translateNum {
    public int translateNum(int num) {
//如果num小于10了，也就没有得拆分了，只有一种情况，例如数字 5 ，只有 f 这个字母表示
        if (num < 10) {
            return 1;
        }
        //大于10的情况，就要分情况讨论了
        int re = num % 100;
        if (re < 10) {
            //情况1.：128105 % 100 = 5，那么5这个数字和无法和0合体的。那么去掉他 （num / 10），继续下一轮递归
            return translateNum(num / 10);
        } else if (re < 26) {
            //情况2.：12810 % 100 = 10 ，可以分成两种情况进行讨论，就是1281 和 128 进行下一轮的递归，也就是对10这两位数选择，可以选择成为ba和k。两种情况
            return translateNum(num / 10) + translateNum(num / 100);
        } else {
            //情况.：128 % 100 = 28，这种情况比26大，因为题目要求是字母，28明显比z大了，所以不能像情况2哪样进行拆分成两个递归进行相加
            return translateNum(num / 10);
        }
    }
}
