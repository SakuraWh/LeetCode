package qz.mt;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(function(arr));
    }

    public static int function(int[] arr) {
        Arrays.sort(arr);
        boolean[] b = new boolean[arr.length];
        Arrays.fill(b,true);
        back(0, arr, new PairMap(), b);
        return 0;
    }
    public static int max = 0;
    public static void back(int begin, int[] arr, PairMap map, boolean[] b) {
//        if if() {
//
//        }if
        int x = arr[begin];
        b[begin] = false;

        for (int i = begin; i < arr.length; i++) {
            int y = -1;
            for(int j = i+1;j<arr.length;j++){
                if(b[j]){
                    y = arr[j];
                    break;
                }
            }
            if(map.contains(x,y))
                continue;
            map.add(x,y);

            back(i+1,arr,map,b);
            map.remove(x,y);
        }
        b[begin] = true;
    }

    public static class PairMap {
        public Map<Integer, Set<Integer>> map = new HashMap<>();

        public boolean contains(int x, int y) {
            return map.containsKey(x) && map.get(x).contains(y);
        }

        public void add(int x, int y) {
            if (!map.containsKey(x))
                map.put(x, new HashSet<>());
            map.get(x).add(y);
        }

        public void remove(int x, int y) {
            map.get(x).remove(y);
            if (map.get(x).size() == 0)
                map.remove(x);
        }

        public int getSum() {
            int n = 0;
            for (Integer integer : map.keySet()) {
                n += map.get(integer).size();
            }
            return n;
        }
    }

}
