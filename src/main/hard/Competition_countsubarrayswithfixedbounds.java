package main.hard;

import java.util.PriorityQueue;

public class Competition_countsubarrayswithfixedbounds {
    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[]{1,3,5,5,3,5,1,5,3,5,1,3,3,3,3},  1, 5));
    }




    static class Solution {

        public long countSubarrays(int[] nums, int minK, int maxK) {
            long ans = 0;
            int maxa,maxb,mina,minb;

            for (int i=nums.length-2;i>=0;i--){
                maxa=nums[i-1];
                mina=nums[i-1];
                maxb=nums[i];
                minb=nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    int tmax = Math.max(maxa,maxb);
                    int tmin = Math.min(mina,minb);
                    if(tmax==maxK&&tmin==minK)
                        ans++;
                    maxa=tmax;

                }
            }



            return ans;


        }
    }
}
