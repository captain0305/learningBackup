package leetcode.代码随想录.数组;

import org.junit.Test;

import java.util.*;

public class test {
    @Test
    public void testMaopao(){
        int[] nums={0,1,2,2,3,0,4,2};
        int val=2;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]==val){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        int count=0;
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i]!=val){
                break;
            }
            count++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(count);
    }

    @Test
    public void test(){
        int[][] intervals = {{2,6},{1,3},{8,10},{15,18}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));

        }

    }

    @Test
    public void  testSubstring(){
        List<String> wordDict=new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        String s="aaaaaaa";
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] booleans=new boolean[s.length()];
        Arrays.fill(booleans,false);
        int last=0;
        for (int i = 0; i < s.length(); i++) {
            lo:
            for (int j = 0; j < wordDict.size(); j++) {
                if (wordDictSet.contains(s.substring(last,i+1))){
                    booleans[i]=true;
                    last=i+1;

                }
            }
        }

        System.out.println(booleans[s.length()-1]);
    }
}
