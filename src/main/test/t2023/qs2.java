package main.test.t2023;

import java.util.Scanner;

public class qs2 {
    public static void main(String[] args) {
        System.out.println(get_max_profit(10000, 7, new double[]{1.0, 2.0, 1.0, 2.0, 2.0, 3.0, 2.0}, 2));
    }

//    public static double get_max_profit(double M, int N, double[] historyPrices, int K) {
//        int len = historyPrices.length;
//        //int[][] dp = new int[N + 1][historyPrices.length + 1];
//        if (len == 0 || K == 0)
//            return 0;
//        double[][] buy = new double[N][K + 1];
//        double[][] sell = new double[N][K + 1];
//
//        for (int j = 0; j <= K; j++) {
//            buy[0][j] = -1;//第一天买入
//            sell[0][j] = 0;//第一天卖不出
//        }
//        for (int i = 1; i < N; i++) {
//            for (int j = 1; j <= K; j++) {
//                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - historyPrices[i]);
//                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + historyPrices[i]);
//            }
//        }
//
//        return sell[N - 1][K] * M;
//    }

    public static double get_max_profit(double M, int N, double[] historyPrices, int K) {
        if (N < 2 || K == 0)
            return 0;
        double[][] dp = new double[N][K+1];
        for (int j = 1; j <= K; j++) {
            double max = -historyPrices[0];
            for (int i = 1; i < N; i++) {
                dp[i][j] = Math.max(dp[i-1][j],max + historyPrices[i]);
                max = Math.max(max,dp[i-1][j-1]-historyPrices[i]);
            }
        }
        return dp[N-1][K]*M;
    }


}
