package leetcode.数组;

public class removeElement {
    public int removeElement(int[] nums, int val) {

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
        return nums.length-count;
    }

    public int removeElement1(int[] nums, int val) {
        int slowIndex=0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex]!=val){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
