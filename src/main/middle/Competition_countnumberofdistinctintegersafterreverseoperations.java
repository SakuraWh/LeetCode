package main.middle;

import java.lang.reflect.Array;
import java.util.*;

public class Competition_countnumberofdistinctintegersafterreverseoperations {
    public static void main(String[] args) {
        System.out.println(new Solution().convert(1010));
    }
    static class Solution {
        public int countDistinctIntegers(int[] nums) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int x : nums){
                list.add(x);
                set.add(x);
            }

            for (int i = 0; i < nums.length; i++) {
                int t = convert(nums[i]);
                list.add(t);
                set.add(t);
            }
            return set.size();
        }
        public int convert(int a){
            List<Integer> list = new LinkedList<>();
            while (a>0){
                list.add(a%10);
                a/=10;
            }
            int ans = 0;
            while (!list.isEmpty()){
                ans *=10;
                ans += list.remove(0);
            }
            return ans;
        }
    }
}
