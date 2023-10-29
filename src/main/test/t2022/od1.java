package main.test.t2022;

import java.util.*;

public class od1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // TODO
            //LinkedList<Integer> list = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] sum = new int[n];
            for (int i = 0; i < n; i++) {
                sum[i] = sc.nextInt();
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                map.clear();
                for (int j = i; j < n; j++) {
                    // i -> j sum是否符合要求
                    map.put(sum[j], map.getOrDefault(sum[j], 0) + 1);
                    if (map.get(sum[j]) == k) {
                        res += n - j;
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }


}