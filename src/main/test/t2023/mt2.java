package main.test.t2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小团在一个n*m的网格地图上探索。网格地图上第 i 行第 j 列的格子用坐标(i,j)简记。初始时，小团的位置在地图的左上角，即坐标(1,1)。地图上的每一个格子上都有一定的金币，特别地，小团位于的初始位置(1,1)上的金币为0。小团在进行探索移动时，可以选择向右移动一格（即从(x,y)到达(x,y+1)）或向下移动一格（即从(x,y)到达(x+1,y)）。地图上的每个格子都有一个颜色，红色或蓝色。如果小团一次移动前后的两个格子颜色不同，那么他需要支付 k 个金币才能够完成这一次移动；如果移动前后的两个格子颜色相同，则不需要支付金币。小团可以在任意格子选择结束探索。现在给你网格地图上每个格子的颜色与金币数量，假设小团初始时的金币数量为0，请你帮助小团计算出最优规划，使他能获得最多的金币，输出能获得的最多金币数量即可。
 *
 * 注意：要求保证小团任意时刻金币数量不小于零。
 */
public class mt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            char[][] color = new char[n][m];
            int[][] coin = new int[n][m];
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                for (int j = 0; j < m; j++) {
                    color[i][j] = s.charAt(j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    coin[i][j] = scanner.nextInt();
                }
            }


            int[][] dp = new int[n][m];

            boolean[][] use = new boolean[n][m];
            use[0][0] = true;
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i > 0 && j > 0) {
                        int left = (color[i][j] == color[i][j - 1] ? 0 : -k);
                        int up = (color[i][j] == color[i - 1][j] ? 0 : -k);
                        if (left > 0 && up > 0) {
                            dp[i][j] = Math.max(dp[i][j-1]+left,dp[i-1][j]+up)+coin[i][j];
                            use[i][j] = true;
                        } else if (left > 0) {
                            dp[i][j] = dp[i][j - 1] + coin[i][j] + left;
                            use[i][j] = true;
                        } else if (up > 0) {
                            dp[i][j] = dp[i - 1][j] + coin[i][j] + up;
                            use[i][j] = true;
                        } else {
                            use[i][j] = false;
                        }
                    } else if (j > 0) {
                        int p = (color[i][j] == color[i][j - 1] ? 0 : -k);
                        if (p + dp[i][j - 1] >= 0) {
                            dp[i][j] = p + coin[i][j] + dp[i][j - 1];
//                            use[i][j] = dp[i][j] >= 0;
//                            use[i][j] = use[i][j] & use[i][j - 1];
                            use[i][j] = true;
                        }

                    } else if (i > 0) {

                        int p = (color[i][j] == color[i - 1][j] ? 0 : -k);
                        if (p + dp[i - 1][j] >= 0) {
                            dp[i][j] = p + coin[i][j] + dp[i - 1][j];
//                            use[i][j] = dp[i][j] >= 0;
//                            use[i][j] = use[i][j] & use[i - 1][j];
                            use[i][j] = true;
                        }

                    }
                    max = use[i][j] ? Math.max(dp[i][j], max) : max;
                }
            }
            System.out.println(max);
        }
    }
}
