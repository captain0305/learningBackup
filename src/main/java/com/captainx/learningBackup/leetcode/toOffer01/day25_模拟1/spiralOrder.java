package com.captainx.learningBackup.leetcode.toOffer01.day25_模拟1;
/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */


/*
想法很简单，需要对矩阵进行遍历
重点是控制边界条件，要控制每次左开右闭合，保证边界控制的一致性
 */
public class spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[]{};
        }
        int index = 0;
        int[] res = new int[matrix.length * matrix[0].length];
        int rowsStart = 0;
        int rowsEnd = matrix.length - 1;
        int columnStrat = 0;
        int columnEnd = matrix[0].length - 1;
        while(rowsStart <= rowsEnd && columnStrat <= columnEnd){
            for(int i = columnStrat; i <= columnEnd; i++){//从左到右包括行尾
                res[index++] = matrix[rowsStart][i];
            }
            for(int i = rowsStart + 1; i <= rowsEnd; i++){//从上到下包括列尾
                res[index++] = matrix[i][columnEnd];
            }
            if(rowsStart < rowsEnd && columnStrat < columnEnd){
                for(int i = columnEnd - 1; i >= columnStrat; i--){//从右到左
                    res[index++] = matrix[rowsEnd][i];
                }
                for(int i = rowsEnd - 1; i > rowsStart; i--){//从下到上
                    res[index++] = matrix[i][columnStrat];
                }
            }
            rowsStart++;
            rowsEnd--;
            columnStrat++;
            columnEnd--;
        }
        return res;
    }

}
