package main.middle;

public class Competition_smallestsubarrayswithmaximumbitwiseor {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.smallestSubarrays(new int[]{1,0,2,1,3});
    }
    static class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int max=0,minlen=1;
                int num =0;
                for (int j = i; j < nums.length; j++) {

                    num = num | nums[j];
                    if(num>max){
                        max = num;
                        minlen = Math.max(minlen,j-i+1);
                    }
                }
                ans[i] = minlen;
            }
            return ans;
        }
    }

}
