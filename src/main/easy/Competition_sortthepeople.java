package main.easy;

import java.util.Arrays;
import java.util.Comparator;

public class Competition_sortthepeople {
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            int[][] tsort = new int[heights.length][2];
            String[] ans = new String[heights.length];

            for (int i = 0; i < heights.length; i++) {
                tsort[i][1] = heights[i];
                tsort[i][0] = i;
            }
            Arrays.sort(tsort, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });
            for (int i = 0; i < heights.length; i++) {
                ans[i]=names[tsort[i][0]];
            }
            return ans;

        }
    }
}
