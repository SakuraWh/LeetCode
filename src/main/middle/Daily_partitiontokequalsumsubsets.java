package main.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Daily_partitiontokequalsumsubsets {
    public static void main(String[] args) {
        //System.out.println(new Solution().canPartitionKSubsets(new int[]{4, 4, 6, 2, 3, 8, 10, 2, 10, 7}, 4));
        //System.out.println(new Solution().canPartitionKSubsets(new int[]{1, 2,2,2,2}, 3));
        System.out.println(new Solution().canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));

    }
    static class Solution {
        boolean[] used;
        int k,target;
        int[] nums;
        public boolean canPartitionKSubsets(int[] nums, int k) {
            Arrays.sort(nums);
            this.k=k;
            this.nums = nums;
            int sum = 0;
            for (int x : nums)
                sum += x;
            if(sum%k!=0)
                return false;
            int target = sum/k;

            this.target = target;
            used = new boolean[nums.length];//一开始都是false，没有访问过

            return dfs(nums.length-1,0, 0);
        }
        public boolean dfs(int index,int sum,int i){

            if(sum==target){
                k--;
                return true;
            }


            if(sum>target)
                return false;

            for (int j = index; j >=0; j--) {
                if(used[j]) continue;
                used[j] = true;
                boolean dfs = dfs(j-1,sum + nums[j], j);
                if (dfs){
                    return true;
                }
                used[j]=false;
                //if (sum == 0) return false;
            }
            return true;
        }
    }
}
