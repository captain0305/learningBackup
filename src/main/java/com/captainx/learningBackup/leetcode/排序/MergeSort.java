package com.captainx.learningBackup.leetcode.排序;


import java.util.Arrays;

public class MergeSort {

    static int res=0;
    //自顶向下归并排序
    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};

        System.out.println("Original array: " + Arrays.toString(arr));

        topDownMergeSort(arr, 0, arr.length - 1,new int[arr.length]);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    // 自顶向下的归并排序
    public static void topDownMergeSort(int[] arr, int left, int right,int[] temp) {
        if (left < right) {
            int middle = (left + right) / 2;

            // 递归地对左右两半进行归并排序
            topDownMergeSort(arr, left, middle,temp);
            topDownMergeSort(arr, middle + 1, right,temp);

            // 合并两个有序数组
            merge(arr, left, middle, right,temp);
        }
    }

    // 合并函数，将两个有序数组合并成一个有序数组
    public static void merge(int[] nums, int left, int mid, int right,int[] temp) {
        int i = left;//左部分首元素
        int j = mid + 1;//右部分首元素
        int t = 0;

        while(i <=mid && j <=right){//在范围之内
            if(nums[i] <= nums[j]){
                temp[t++] = nums[i++];
            }else{
                res += (mid - i + 1);//只需要这行代码
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid){//右边遍历完事了   左边还剩呢
            temp[t++] = nums[i++];
        }
        while( j <= right){//左边遍历完事了   右边还剩了
            temp[t++] = nums[j++];
        }

        t = 0;//将temp中的元素  全部都copy到原数组里边去
        while (left <=right){
            nums[left++] = temp[t++];
        }


    }
}
