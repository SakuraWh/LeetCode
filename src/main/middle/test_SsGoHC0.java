package main.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test_SsGoHC0 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        list.sort((a, b) -> a[0] - b[0]);
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0]<end){
                end = Math.max(end,list.get(i)[1]);
            }else{
                res.add(new int[]{start,end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        res.add(new int[]{start,end});
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
