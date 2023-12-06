package com.captainx.learningBackup.leetcode.toOffer01.day03_字符串;
/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。


 */
public class replaceSpace {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public String replaceSpace(String s,String a) {
        String replace =s.replace(" ","%20");
        return replace;
    }


}
