package leetcode.toOffer01.day10_动态规划3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
    public void test(){
        String a="asdfqeowas";
        char[] chars = a.toCharArray();
        Map<Character,Integer> dic=new HashMap<>();

        int len=0;
        char last=Character.MIN_VALUE;
        int result=0;
        for (int i = 0; i < chars.length; i++) {
            int index=dic.getOrDefault(chars[i],-1);
            System.out.println(index);
            dic.put(chars[i],i);

        }
    }
}
