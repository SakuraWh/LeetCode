package main.middle;

import java.util.*;

public class Test_topkfrequentelements {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int x : nums){
                map.put(x,map.getOrDefault(x,0)+1);
            }
            Queue<int[]> queue = new PriorityQueue<>((a, b)->a[1]-b[1]);//采用小根堆，维护k大小

            for (Integer integer : map.keySet()) {
                if(queue.size()<k){
                    queue.add(new int[]{integer,map.get(integer)});
                }else if(map.get(integer)>queue.peek()[1]){
                    queue.poll();
                    queue.offer(new int[]{integer,map.get(integer)});
                }
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = queue.poll()[0];
            }
            return ans;
        }
    }
}
