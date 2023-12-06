package com.captainx.learningBackup.leetcode.排序;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        int result = binarySearch(nums, target);
        if (result != -1) {
            System.out.println("目标元素 " + target + " 在数组中的索引位置是: " + result);
        } else {
            System.out.println("目标元素 " + target + " 不存在于数组中。");
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止整数溢出

            if (nums[mid] == target) {
                return mid; // 找到目标元素，返回索引
            } else if (nums[mid] < target) {
                left = mid + 1; // 目标元素在右侧
            } else {
                right = mid - 1; // 目标元素在左侧
            }
        }

        return -1; // 目标元素不存在于数组中
    }
}
