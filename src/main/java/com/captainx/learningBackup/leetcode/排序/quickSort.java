package com.captainx.learningBackup.leetcode.排序;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};

        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    //给定一个字符串，找出该字符串的最长回文子串。回文字符串指的就是从左右两边看都一样的字符串，如 aba，cddc 都是回文字符串。字符串 abbacdc 存在的回文子串有 abba 和 cdc，因此它的最长回文子串为 abba
    // 快速排序主函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            // 递归地对基准元素左右两边的子数组进行快速排序
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // 分区函数，用于选择基准元素并将数组划分成两部分
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准
        int i = low - 1; // i 用于追踪小于基准的元素的位置

        // 遍历数组，将小于基准的元素交换到前面
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // 交换元素，将小于基准的元素放到左边
            }
        }

        swap(arr, i + 1, high); // 将基准元素放到正确的位置 i+1的值是大于high的
        return i + 1; // 返回基准元素的位置
    }

    // 交换数组中两个元素的位置
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
