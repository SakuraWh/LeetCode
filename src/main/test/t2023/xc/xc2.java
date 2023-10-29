package main.test.t2023.xc;

import java.util.Scanner;

public class xc2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            func(n);
        }

    }

    public static void func(int n) {
        int a, b;
        if (n % 2 == 0)
            a = b = n / 2;
        else {
            a = (n - 1) / 2;
            b = (n + 1) / 2;
        }
        while (dfs(a, b) != 1) {
            a--;
            b++;
        }
        System.out.println(a + " " + b);
    }

    public static int dfs(int a, int b) {
        return b == 0 ? a : dfs(b, a % b);
    }

}
