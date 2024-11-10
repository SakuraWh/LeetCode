package main.test.t2022;


import java.util.Random;

public class test {
//    public static void main(String[] args) {
//        Random random = new Random();
//        Soulation soulation = new Soulation();
//        for (int i = 0; i < 10; i++) {
//            int n = random.nextInt(1, 20);
//            int[] a = new int[n + 5];
//            for (int j = 0; j < n; j++) {
//                a[j] = random.nextInt(1, 20);
//            }
//            int my = soulation.func_1(n, a);
//            int he = soulation.func_2(n, a);
//            if (my == he) {
//                System.out.println("序号" + i + "测试成功！");
//
//            }else {
//                System.out.println(n);
//                for (int j = 0; j < n; j++) {
//                    System.out.print(a[j]+" ");
//                }
//                return;
//            }
//
//        }
//
//
//    }
}


class Soulation {
    public int func_1(int n, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if ((sum ^ 1) == 1)
            return 0;
        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        dp[0][0] = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > target) {
                return 0;
            }
            for (int j = 0; j < target + 1; j++) {
                if (j < arr[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i]];
            }
        }
        return dp[n - 1][target];
    }

    public int func_2(int n, int[] a) {
        int[] dp = new int[100005];
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += a[i];
        }
        // 和为奇数不可能成立
        if (s % 2 == 1) {
            return 0;
        }
        s /= 2;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 如果存在一个数，他大于总和的一半，那么也一定不可能存在合法方案
            if (a[i] > s) {

                return 0;
            }
            // 背包更新,逆向转移.
            for (int j = s; j >= a[i]; j--) {
                dp[j] += dp[j - a[i]];
            }
        }
        return dp[s];
    }
}

