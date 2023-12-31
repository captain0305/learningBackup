package com.captainx.learningBackup.leetcode.toOffer01.day03_字符串;
/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

输入: s = "abcdefg", k = 2
输出: "cdefgab"

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
 */
public class reverseLeftWords {
    public static void main(String[] args) {

    }
    public String reverseLeftWords(String s, int n) {
        StringBuilder res=new StringBuilder();

        char[] arr = s.toCharArray();

        for(int i = n; i < s.length(); i++) {
            char c = s.charAt(i);
            res.append(c);
        }
        for (int i=0;i<n;i++){
            char c=s.charAt(i);
            res.append(c);
        }
        return res.toString();
    }
    //最快
    public String reverseLeftWords2(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
