package qz.tx.second;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        PriorityQueue<Long> tree = new PriorityQueue<Long>((a, b) -> (a > b ? 1 : 0));
        for (int i = 0; i < n; i++) {

            tree.add((long) sc.nextInt());
        }

        for (int i = 0; i < k; i++) {
            long min = tree.poll();
            if ((min & 1) == 1)
                min = min * 2;
            else
                min = min * 2 + 1;
            tree.add(min);
        }

        long res = 0;
        while (!tree.isEmpty()) {
            res += tree.poll();
        }
        System.out.println(res);


    }
}
