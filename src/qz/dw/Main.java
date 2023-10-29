package qz.dw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long L = sc.nextLong();
            long R = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(function(L, R, m));
        }
    }

    public static long function(long L, long R, long m) {
        long l = 0;
        long r = 0;
        if (m % 2 == 0) {
            l = m / 2 - 1;
            r = m / 2 + 1;
        } else {
            l = m / 2;
            r = l + 1;
        }
        // 判断lr到边界的距离
        long tr = R - r + 1;
        long tl = l - L + 1;
        if (tr < 0 || tl < 0)
            return 0;
        return Math.min(tr, tl);

    }
}
