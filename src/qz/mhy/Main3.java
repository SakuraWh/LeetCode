package qz.mhy;

import java.util.Scanner;

public class Main3 {
    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();

        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int n1 = arr[i];
            for (int j = i + 1; j <= n; j++) {
                int n2 = arr[j];
                int differ = j - i;
                ans = (ans + (long) n1 * (long) n2 * (long) differ)%mod;
            }
        }
        System.out.println(ans);
    }
}
