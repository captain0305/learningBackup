package com.captainx.learningBackup.leetcode.toOffer01.day25_模拟1;

import org.junit.Test;

public class test {
    @Test
    public void testSprial(){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int loop = 0;  // 控制循环次数
        int width=matrix[0].length;
        int height=matrix.length;
        int temp=Math.max(width,height);
        int[] res=new int[height*width];
        int start = 0;  // 每次循环的开始点(start, start)
        int count =0;  // 定义填充数字
        int i, j;
        int left_border=-1;
        int right_border=width;
        int up_border=-1;
        int down_border=height;
        lo:
        while (loop++ < temp / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < right_border-loop; j++) {
                res[count] = matrix[start][j];
                count++;
            }


            // 模拟右侧从上到下
            for (i = start; i < down_border-loop; i++) {
                res[count] = matrix[i][j];
                count++;
            }
            down_border--;


            // 模拟下侧从右到左
            for (; j >= left_border+loop+1; j--) {
                res[count] = matrix[i][j];
                count++;
            }
            left_border++;
            // 模拟左侧从下到上
            for (; i >= up_border+loop+1; i--) {
                res[count] = matrix[i][j];
                count++;
            }
            right_border++;
            if(count== res.length)
                break lo;
        }

//        if (temp % 2 == 1) {
//            res[count] = matrix[start][start];
//        }
        for (int k = 0; k < res.length; k++) {
            System.out.println(res[k]);
        }
    }
}
