package main.test.t2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // TODO
            List<int[]> list = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int[] t = new int[3];
                t[0] = i;
                int p = sc.nextInt();
                t[2] = sc.nextInt();
                list.add(t);
                path.add(p);
            }
            list.sort((a, b) -> a[2] - b[2]);
            path.sort((a, b) -> a - b);
            int k = 0;
            for (int[] ints : list) {
                ints[1] = path.get(k++);
            }
            list.sort((a, b) -> a[0] - b[0]);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i)[1] + " " + list.get(i)[2]);
            }

        }
    }
}