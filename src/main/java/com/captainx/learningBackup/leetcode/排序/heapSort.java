package com.captainx.learningBackup.leetcode.排序;

import java.util.Arrays;

public class heapSort {

    public static void main(String[] args) {
        int[] arr = {2,5,3,1,10,4};

        System.out.println("Original array: " + Arrays.toString(arr));
        sortHeap(arr, arr.length);
       // buildHeap(arr,arr.length);
        //heapify(arr,arr.length,0);


        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void sortHeap(int[] tree,int n){
        buildHeap(tree,n);

        for (int i = n-1; i >=0 ; i--) {
            //交换头尾节点，保证最大值到最后
            swap(tree,i,0);
            //再对跟节点左heapify操作
            heapify(tree,i,0);
        }
    }


    public static  void buildHeap(int[] tree,int n){
        int lastNode=n-1;
        int parent=(lastNode-1)/2;
        //建堆，从下到上
        for (int j = parent; j >=0; j--) {
            heapify(tree,n,j);
        }
    }

    public static void heapify(int[] tree ,int n, int i){
        if (i>=n){
            return;
        }
        //树的节点
        //左子树
        int c1=2*i+1;
        //右子树
        int c2=2*i+2;
        int max=i;

        //左节点小于数组长度且大于当前跟节点
        if (c1<n&&tree[c1]>tree[max]){
            max=c1;
        }
        //右节点
        if (c2<n&&tree[c2]>tree[max]){
            max=c2;
        }

        if (max!=i){
            //跟节点和较大节点交换
            swap(tree,max,i);
            //接下来的树进行heapify
            heapify(tree,n,max);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
