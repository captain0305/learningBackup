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
            swap(tree,i,0);
            heapify(tree,i,0);
        }
    }


    public static  void buildHeap(int[] tree,int n){
        int lastNode=n-1;
        int parent=(lastNode-1)/2;

        for (int j = parent; j >=0; j--) {
            heapify(tree,n,j);
        }
    }

    public static void heapify(int[] tree ,int n, int i){
        if (i>=n){
            return;
        }

        int c1=2*i+1;
        int c2=2*i+2;
        int max=i;
        if (c1<n&&tree[c1]>tree[max]){
            max=c1;
        }

        if (c2<n&&tree[c2]>tree[max]){
            max=c2;
        }

        if (max!=i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
