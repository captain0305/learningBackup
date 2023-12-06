package com.captainx.learningBackup.leetcode.toOffer01.day22_位运算2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test {
    @Test
    public void testMapEntry(){
        Map<Integer, Integer> map = new HashMap();
        int[] nums={1,4,6,2,3,2,1,1,2,3,3,6,6};
        for(int i = nums.length - 1; i >= 0; --i){
            int key = nums[i];
            if(!map.containsKey(key)){
                // 如果之前没有遇到这一数字，则放入 map 中
                map.put(key, 1);
            }else{
                // 如果之前遇到过这一数字，则出现次数加 1
                map.put(key, map.get(key) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        //hashmap两种迭代方式
        for (Map.Entry<Integer, Integer> entry : entries) {

            System.out.println(entry.getKey()+"---"+entry.getValue());
        }

        for(Iterator<Map.Entry<Integer,Integer>>it=entries.iterator();it.hasNext();){
            Map.Entry<Integer,Integer> entry= it.next();
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
        System.out.println(entries);

    }
}
