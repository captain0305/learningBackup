package com.captainx.learningBackup.leetcode.toOffer01.day04_查找算法;

import org.junit.Test;

import java.util.HashMap;

public class test {
    @Test
    public void testFindRepeatNum(){
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] nums={2,3,1,0,2,5,3};
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                Integer integer = map.get(nums[i]);
                map.replace(nums[i],integer+1);
            }else {
                map.put(nums[i],1);
            }
        }

    }
    @Test
    public void missingNum(){
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] nums={0,1,2,3,4,5,10};
        int len=nums.length;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
        }
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(i)){
                System.out.println(i);
            }
        }
    }
}
