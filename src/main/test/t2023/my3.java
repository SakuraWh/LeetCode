package main.test.t2023;

import java.util.*;

public class my3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] path = new int[n][m];
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    path[i][j] = sc.nextInt();
                    List<int[]> list = map.get(path[i][j]);
                    if (list == null)
                        list = new ArrayList<>();
                    list.add(new int[]{i, j});
                }
            }
            // dp
            int[][] dp = new int[n][m];
            dp[n-1][m-1]=0;

        }

    }
}
