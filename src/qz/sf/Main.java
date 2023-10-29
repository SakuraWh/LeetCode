package qz.sf;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        method(n);
        System.out.println(min_zc * 4);
    }


    public static int N = 0;
    public static int min_zc = Integer.MAX_VALUE;
    public static int zc = 0;

    public static void method(int n) {
        if (N > n || zc > min_zc) {
            return;
        }
        if (N == n) {
            min_zc = Math.min(zc, min_zc);
            return;
        }
        for (int i = 1; i <= 50000; i++) {
            int sp = i * i;
            N += sp;
            zc += i;
            method(n);
            N -= sp;
            zc -= i;
        }
    }

    // 回溯
}
