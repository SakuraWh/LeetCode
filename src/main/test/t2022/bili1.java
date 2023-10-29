package main.test.t2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class bili1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(new int[]{x, y});
            }
            if (N == 0)
                System.out.println(0.000);
            //TODO
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] - o2[1] == 0) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[1];
                }
            });

            System.out.printf("%.2f", binary(list, 0, list.size() - 1));


        }
    }
    static class point{
        int x,y;
        boolean type;
    }

    public static Double binary(List<int[]> list, int left, int right) {
        if (left >= right)
            return Double.MAX_VALUE;
        if (left == right - 1) {
            int[] a = list.get(left);
            int[] b = list.get(right);
            return getInstance(a, b);
        }
        int mid = (left + right) / 2;
        double l = binary(list, left, mid - 1);
        double r = binary(list, mid + 1, right);
        int[] a = list.get(mid - 1);
        int[] b = list.get(mid + 1);
        double ll = getInstance(a, list.get(mid));
        double rr = getInstance(b, list.get(mid));
        return Math.min(Math.min(ll, l), Math.min(rr, r));
    }

    public static double getInstance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
