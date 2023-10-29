package qz.bdjr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();

        System.out.println(method(n, k, str.toCharArray()));
    }

    public static long method(int n, int k, char[] str) {
//        int m = 0;
//        for (char c : str)
//            if (c == 'A') m++;
//
//        int t = 0;
//        if (k > m)
//            t = k / m-1;
//        long ans = (long) t * n;
//        k = k - t * m;
//        for (int i = 0; i < n; i++) {
//            if (k == 0)
//                break;
//            if (str[i] == 'A')
//                k--;
//            ans++;
//        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == 'A')
                k--;
            ans++;
            if (k == 0)
                break;
            if (i == n - 1)
                i = -1;
        }
        return ans;
    }
}
