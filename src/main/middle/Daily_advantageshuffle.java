package main.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Daily_advantageshuffle {
    public static void main(String[] args) {
        System.out.println(new Solution().advantageCount(new int[]{2,0,4,1,2}, new int[]{1,3,0,0,2}));
    }

    static class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            for (int i = 0; i < nums1.length; i++) {
                tree.put(nums1[i], 1+tree.getOrDefault(nums1[i],0));
            }
            int[] ans = new int[nums1.length];
            int k = 0;
            for (int a : nums2) {
                Integer integer = tree.higherKey(a);
                if (integer == null) {
                    ans[k++] = tree.firstKey();
                    if(tree.get(tree.firstKey())==1)
                        tree.remove(tree.firstKey());
                    else
                        tree.put(tree.firstKey(),tree.get(tree.firstKey())-1);
                } else {
                    ans[k++] = integer;

                    if(tree.get(integer)==1)
                        tree.remove(integer);
                    else
                        tree.put(integer,tree.get(integer)-1);
                }
            }
            return ans;
        }
    }
}
