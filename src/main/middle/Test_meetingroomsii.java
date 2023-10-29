package main.middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test_meetingroomsii {
        public int minMeetingRooms(int[][] intervals) {
            List<int[]> list = new ArrayList<>();
            for (int[] ints : intervals) {
                list.add(new int[]{ints[0],1});
                list.add(new int[]{ints[1],-1});
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0])
                        return o1[1]-o2[1];
                    return o1[0] - o2[0];
                }
            });
            int max = 0;
            int count = 0;
            for (int[] a : list) {
                count+=a[1];
                max = Math.max(count,max);
            }
            return max;
        }
}
