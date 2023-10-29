package main.test.t2023.xc;

import java.util.Scanner;

public class xc4 {
    private static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = (func(arr[0]))%mod;
        if (n == 1) {
            System.out.println(dp[0]);
            return;
        }
        dp[1] = (func(arr[1]) + dp[0])%mod;

        for (int i = 2; i < n; i++) {
            dp[i] = ((func(arr[i]) + dp[i - 1]) % mod + Math.min(arr[i - 2], arr[i])) % mod;
        }

        System.out.println(dp[n - 1]);
    }

    private static int func(int x) {
        return (x * (x + 1) / 2)%mod;
    }
}
