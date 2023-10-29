package main.middle;

import java.util.*;

public class Daily_getkthmagicnumberlcci {
    public static void main(String[] args) {
        new Solution().getKthMagicNumber(5);
        List list;
    }
    static class Solution {
        public int getKthMagicNumber(int k) {
            int[] factors = {3, 5, 7};
            Integer s;
            Set<Long> seen = new HashSet<Long>();
            PriorityQueue<Long> heap = new PriorityQueue<Long>();
            seen.add(1L);
            heap.offer(1L);
            int magic = 0;
            for (int i = 0; i < k; i++) {
                long curr = heap.poll();
                magic = (int) curr;
                for (int factor : factors) {
                    long next = curr * factor;
                    if (seen.add(next)) {
                        heap.offer(next);
                    }
                }
            }
            return magic;
        }
    }
}
