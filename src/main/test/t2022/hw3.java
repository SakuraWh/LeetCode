package main.test.t2022;

import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // TODO
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }
            if (sum <= m) {
                System.out.println(-1);
                return;
            }
            int i = 0;
            int res = 0;
            int j = a[n - 1];
            while (i <= j) {
                int mid = (i + j) / 2;
                //判断和
                if (check(mid, a, m)) {
                    i = mid + 1;
                    res = mid;
                } else {
                    j = mid - 1;
                }
            }
            System.out.println(res);
        }
    }

    public static boolean check(int min, int a[], int target) {
        int sum = 0;
        for (int i : a) {
            sum += Math.min(min, i);
            if (sum > target)
                return false;
        }
        return true;
    }
}