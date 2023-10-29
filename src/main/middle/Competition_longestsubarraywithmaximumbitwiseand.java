package main.middle;

public class Competition_longestsubarraywithmaximumbitwiseand {
    class Solution {
        public int longestSubarray(int[] nums) {
            int max =Integer.MIN_VALUE;
            int max_num = 0;
            for (int num : nums){
                if(max<num){
                    max =num;
                    max_num = 1;
                }else if(max == num){
                    max_num++;
                }
            }

            int len = nums.length;
            for (int i = len; i >1; i--) {
                for (int j = 0; j <len-i+1; j++) {
                    int x = nums[j];
                    for (int k = j; k <j+i; k++) {
                        x =x&nums[k];
                    }
                    if(x==max)
                        return i;
                }
            }
            return 1;
        }
    }
}
