package leetcode.toOffer01.day24_数学2;
//约瑟夫环问题
//dp写法

/*
删除的第一个数字为(m-1)%n
第二轮从t=m%n开始
(t+m-1)%(n-1)
 */
public class lastRemaining_best {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }
/*
比如0123 n=4 m=3 删掉2位置
 */
    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);//递归
        return (m + x) % n;
    }
}
