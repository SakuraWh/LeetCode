package main.middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Test_SsGoHC {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        list.sort((a, b) -> a[0] - b[0]);
//        list.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        for (int i = 0; i < list.size(); i++) {
            int[] t = list.get(i);
            for (int j = i + 1; j < list.size(); ) {
                if (list.get(j)[0] <= t[1]){
                    t[1] = Math.max(list.get(j)[1],t[1]);
                    list.remove(list.get(j));
                }else{
                    break;
                }
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;

    }

}
