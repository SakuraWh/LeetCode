package qz.wy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] arr = sc.next().toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            Map<String, Integer> tm = map.getOrDefault(arr.length, new HashMap<>());
            tm.put(s, tm.getOrDefault(s, 0) + 1);
            map.put(s.length(), tm);
        }

        long count = 0;
        for (Integer t : map.keySet()) {
            Map<String, Integer> m = map.get(t);
            for (String s : m.keySet()) {
                Integer i = m.get(s);
                count += getZH(i);
            }
        }
        System.out.println(count);


    }

    public static long getZH(long n) {
        return n*(n-1) / 2;
    }

    public static int countPair(String[] strings){
        Map<String,Integer> map = new HashMap<>();
        for (String s : strings) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            String ss = new String(str);
            map.put(ss,map.getOrDefault(ss,0)+1);

        };
        int sp=0;
        for (Integer value : map.values()) {
            sp+=value*(value-1)/2;
        }
        return sp;
    }
}
