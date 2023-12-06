package com.captainx.learningBackup.leetcode.toOffer01.day05_查找进阶;

import java.util.HashMap;

/*
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例 1:

输入：s = "abaccdeff"
输出：'b'
示例 2:

输入：s = ""
输出：' '
 */
public class firstUniqChar {
    public char firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                Integer integer = map.get(chars[i]);
                map.replace(chars[i],integer+1);
            }else {
                map.put(chars[i],1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i])==1){
                return chars[i];
            }
        }
        return ' ';

    }

    //最快
    public char firstUniqChar1(String s) {
        //判断字母a-z是否在s中只出现了一次，在判断哪一个是最先的
        int ans = 50001; //s长度小于5000
        int first, last;
        for(int i = 0; i < 26; i++){
            char ch = (char)('a' + i);
            first = s.indexOf(ch);
            if(first != -1){
                //说明s中包含有该字母
                last = s.lastIndexOf(ch);
                if(first == last){
                    //说明该字母只出现了一次，记录出现位置
                    ans = ans > first ? first : ans;
                }
            }
        }
        return ans == 50001 ? ' ' : s.charAt(ans);
    }
}
