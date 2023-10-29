package qz.zx;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] prr = new int[p];
        int[] qrr = new int[q];
        for (int i = 0; i < p; i++) {
            prr[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            qrr[i] = sc.nextInt();
            set.add(qrr[i]);
        }

        for (int i : prr) {
            if (set.contains(i)) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                continue;
            }
            list.add(i);
        }
        List<Integer> prior = new ArrayList<>();
        for (int i : qrr) {
            int t = map.get(i);
            for (int j = 0; j < t; j++) {
                prior.add(i);
            }
        }
        for (Integer x : prior) {
            System.out.print(x+" ");
        }


        list.sort((a, b) -> a - b);
        for (Integer x : list) {
            System.out.print(x+" ");
        }


    }


}
