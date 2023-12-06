package com.captainx.learningBackup.leetcode.toOffer01.day17_排序2;
/*
1 median 1
1 3 median 2.0 plus 3 minus 1
1 3 5 median 3.0 plus 5 minus 1
1 2 3 5 median 2.5 plus 3 minus 2
1 1 2 3 5 median 2 plus 3 minus 1
 */
public class MedianFinder2 {

    double median;
    double median_plus;
    double median_minus;

    int len=0;

    public MedianFinder2() {

    }

    public void addNum(int num) {

        if(len==0){
            median=num;
        }
        if(len==1){
            if(median>num){
                median_minus=num;
                median_plus=(int)median;
                median=(num+median)/2;
            } else if (median<=num) {
                median_plus=num;
                median_minus=(int)median;
                median=(num+median)/2;
            }
        }
        if(len>1){
            if(len%2==0){
                if(median_minus>=num){
                    double tmp=median_minus;
                    median_minus=num;
                    median=tmp;
                } else if (median_plus<=num) {
                    double tmp=median_plus;
                    median_plus=num;
                    median=tmp;
                } else if (median_minus<num&&median_plus>num) {
                    median=num;
                }
            } else if (len%2==1) {
                if(median_minus>=num){
                    double tmp=median;
                    median=(median+median_minus)/2;
                    median_minus=tmp;
                } else if (median_plus<=num) {
                    double tmp=median;
                    median=(median+median_plus)/2;
                    median_plus=tmp;
                } else if (median_minus<num&&median>=num) {
                    double tmp=median;
                    median=(num+median)/2;
                    median_minus=num;
                    median_plus=tmp;
                } else if (median<num&&median_plus>num) {
                    double tmp=median;
                    median=(num+median)/2;
                    median_plus=num;
                    median_minus=tmp;
                }
            }

        }
        len++;
    }

    public double findMedian() {

        return median;

    }
}
