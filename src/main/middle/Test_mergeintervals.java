package main.middle;

import java.util.*;

public class Test_mergeintervals {
    public static int[][] merge1(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }
        List<int[]> res = new ArrayList<>();
        int[][] sum = new int[map.size()][2];
        int k = 0;
        for (Integer integer : map.keySet()) {
            sum[k][0] = integer;
            sum[k][1] = map.get(integer);
            k++;
        }
        Arrays.sort(sum, (a, b) -> a[0] - b[0]);
        int left = sum[0][0];
        for (int i = 1; i < sum.length; i++) {
            sum[i][1] += sum[i - 1][1];
            if (left == -1) {
                left = sum[i][0];
            }
            if (sum[i][1] == 0) {
                res.add(new int[]{left, sum[i][0] - 1});
                left = -1;
            } else if (sum[i][1] == sum[i][1]) {
                res.add(new int[]{left, sum[i][0] - 1});
                left = sum[i][0];
            }
        }
        int[][] ints = new int[res.size()][];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = res.get(i);
        }
        return ints;

    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> source = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            source.add(interval);
        }
        source.sort((a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < source.size()) {
            int[] left = source.get(i);
            int j = i + 1;
            for (;j < source.size(); j++) {
                int[] right = source.get(j);
                if (left[1] < right[0]){

                    break;
                    //无法合并
                }else {
                    left[1] = Math.max(left[1],right[1]);
                }
            }
            i = j;
            res.add(left);

        }
        int[][] ints = new int[res.size()][];
        for (i = 0; i < ints.length; i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        //int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ints = {{1, 4}, {4, 6}};
        //int[][] ints = {{1, 4}, {5, 6}};
        System.out.println(merge(ints));
    }
}
