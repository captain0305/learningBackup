package leetcode.toOffer01.day16_排序1;

import org.junit.Test;

public class test {
    @Test
    public void testCompareto(){
        String a="3";
        String b="30";
        System.out.println((a+b).compareTo(b+a));//330>303返回正数
        System.out.println((b+a).compareTo(a+b));
    }

    @Test
    public void testSort(){
        int[] nums= {1,3,5,7,2,0,0};

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
