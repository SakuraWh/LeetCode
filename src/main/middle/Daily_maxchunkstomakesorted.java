package main.middle;

import java.util.Arrays;

public class Daily_maxchunkstomakesorted {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,0,2,3,4};
        //int[] arr = new int[]{1,0,2,3,4};
//        int[] nums = arr.clone();
//        Arrays.sort(arr);
//        boolean check = solution.check(0, 0, nums, arr);
//        System.out.println(check);
        System.out.println(solution.maxChunksToSorted(arr));
    }
    static class Solution {
        int max = 0;
        public int maxChunksToSorted(int[] arr) {
            int[] nums = arr.clone();
            Arrays.sort(arr);
            dfs(0,0,nums,arr);
            return max;
        }
        public void dfs(int begin,int k,int[] nums,int[] arr){
            if(nums.length-begin+k<max){
                return;
            }
            max = Math.max(k,max);
            for (int i=begin;i<nums.length;i++){
                if(!check(begin,i,nums,arr))
                    continue;
                dfs(i+1,k+1,nums,arr);
            }
        }
        public boolean check(int i,int j,int[] nums,int[] arr){
            int[] temp  = new int[j-i+1];
            for(int k = 0;k<=j-i;k++)
                temp[k]=nums[k+i];
            Arrays.sort(temp);
            for(int k = 0;k<=j-i;k++)
                if(temp[k]!=arr[k+i])
                    return false;
            return true;
        }


    }
}
