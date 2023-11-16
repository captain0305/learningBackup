package leetcode.toOffer01.day23_数学1;
/*
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。



示例:

输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
 */

/*
将表格的主对角线全部设置为1——将表格分割为上三角和下三角两部分
 */
public class constructArr {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;


    }

    public int[] constructArr1(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];

        for(int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

            }
        }

        return b;


    }
}
