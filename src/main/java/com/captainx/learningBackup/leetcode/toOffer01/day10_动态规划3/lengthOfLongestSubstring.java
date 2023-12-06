package com.captainx.learningBackup.leetcode.toOffer01.day10_动态规划3;

import java.util.*;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic=new HashMap<>();
        char[] chars = s.toCharArray();
        int len=0;
        char last=Character.MIN_VALUE;
        int result=0;
        for (int i = 0; i < chars.length; i++) {
            int index=dic.getOrDefault(chars[i],-1);

            dic.put(chars[i],i);
            len=len<i-index?len+1:i-index;
            result=Math.max(result,len);
        }
        return result;

    }

}
