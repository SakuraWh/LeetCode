package main.test.t2023;

import java.util.Scanner;

public class tx4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // 统计1的个数，当有偶数个1且只有一个非1的数时，符合要求

        System.out.println(res+n);

    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int res = 0;
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[] dp_cj = new int[n];
//        int[] dp_yh = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            dp_cj[i] = a[i];
//            dp_yh[i] = a[i];
//            for (int j = i+1; j < n; j++) {
//                dp_cj[j] = dp_cj[j-1] * a[j];
//                dp_yh[j] = dp_yh[j-1] ^ a[j];
//                if (dp_yh[j] == dp_cj[j])
//                    res ++;
//            }
//        }
//
//        System.out.println(res+n);
//
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int res = 0;
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[][] dp_cj = new int[n][n];
//        int[][] dp_yh = new int[n][n];
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            dp_cj[i][i] = a[i];
//            dp_yh[i][i] = a[i];
//            dp[i][i] = 1;
//            for (int j = i+1; j < n; j++) {
//                dp_cj[i][j] = dp_cj[i][j-1] * a[j];
//                dp_yh[i][j] = dp_yh[i][j-1] ^ a[j];
//                if (dp_yh[i][j] == dp_cj[i][j]){
//                    res ++;
//                    dp[i][j] = 1;
//                }
//
//            }
//        }
//        System.out.println("--------");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp_cj[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("--------");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp_yh[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("--------");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println(res+n);
//
//    }
//

}