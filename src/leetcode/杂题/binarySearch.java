package 杂题;

public class binarySearch {
    class Solution {
        public int search(int[] nums, int target) {
            int high=nums.length-1;
            int low=0;
            while(high>low+1){
                if(nums[(high+low)/2]>target){
                    high=(high+low)/2-1;
                }else if(nums[(high+low)/2]<target){
                    low=(high+low)/2+1;
                }else if(nums[(high+low)]/2==target){
                    return (high+low)/2;
                }

            }
            return -1;
        }
    }
}
