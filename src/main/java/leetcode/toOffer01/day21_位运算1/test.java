package leetcode.toOffer01.day21_位运算1;

import org.junit.Test;

public class test {
    @Test
    public void test(){
        int a=11;
        a=a>>1;
        System.out.println(a);
        a=a>>1;
        System.out.println(a);
        a=a>>1;
        System.out.println(a);
        a=a>>1;
        System.out.println(a);
    }

    @Test
    public void testHammingWeight(){
        int n=-3;
        int result=0;

        while (n!=0){
            result+=n&1;
            n=n>>>1;
            System.out.println(n);
        }
        //System.out.println(n);
        System.out.println(result);
    }
}
