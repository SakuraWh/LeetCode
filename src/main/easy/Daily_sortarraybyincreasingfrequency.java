package main.easy;

import java.util.*;

public class Daily_sortarraybyincreasingfrequency {
    class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer,Integer> map =new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            List<int[]> list = new ArrayList<>();
            for(int key: map.keySet()){
                list.add(new int[]{key,map.get(key)});
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]==o2[1]?o2[0]-o1[0]:o1[1]-o2[1];
                }
            });
            int[] ans = new int[nums.length];
            int k =0;
            for (int i = 0; i <list.size(); i++) {
                int[] t = list.get(i);
                for (int j = 0; j < t[1]; j++) {
                    ans[k] = t[0];
                    k++;
                }
            }
            return ans;



        }
    }
}
