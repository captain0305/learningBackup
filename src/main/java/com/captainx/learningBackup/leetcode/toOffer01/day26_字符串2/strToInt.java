package com.captainx.learningBackup.leetcode.toOffer01.day26_字符串2;
/*
写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。



首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
 */
public class strToInt {
    public int strToInt(String str) {
        //去除str首尾的多余空格
        char[] array = str.trim().toCharArray();
        //如果array的长度为0 返回0
        if (array.length==0) return 0;
        //sign表示标志位  1为正  -1 为负  i代表array从何处开始遍历
        int res = 0, sign = 1, i = 1;
        //设置限制值，因为在遍历中先判断res是否越界，再向res赋值，因而对limit的要求/10
        int limit = Integer.MAX_VALUE / 10;
        //如果array[0]=- 表明该数是负数  sign =-1
        if (array[0]=='-') sign = -1;
        else if (array[0]!='+') i = 0;
        for (int j = i; j < array.length; j++) {
            //判断当前字符是否为数字  不是直接退出
            if (array[j]>'9'||array[j]<'0') break;
            //判断遍历到j-1的位置后  res是否大于limit 如果当前res已经大于limit  加上array[j]一定越界
            //当res等于limit时，我们需要判断array[j]是否大于Integer.MAX_VALUE的末位数7
            if (res>limit||res==limit&&array[j]>'7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (array[j] - '0');
        }
        return sign*res;
    }
}
