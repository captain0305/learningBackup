package com.captainx.learningBackup.leetcode.代码随想录.栈与队列;

import java.util.*;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。



示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 */
public class topKFrequent {
    public class keyvalue {
        public int key;
        public int value;

        keyvalue() {
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        keyvalue[] a = new keyvalue[entries.size()];
        int i = 0;
        for (int j = 0; j < entries.size(); j++) {
            a[j] = new keyvalue();
        }
        for (Map.Entry<Integer, Integer> entry : entries) {
            a[i].key = entry.getKey();
            a[i].value = entry.getValue();
            i++;
        }
        Arrays.sort(a, new Comparator<keyvalue>() {
            @Override
            public int compare(keyvalue o1, keyvalue o2) {
                return o2.value - o1.value;
            }
        });
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = a[j].key;
        }
        return res;
    }
}
