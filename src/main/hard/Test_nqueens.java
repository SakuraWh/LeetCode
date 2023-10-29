package main.hard;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test_nqueens {
    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }

    static class Solution {
        List<List<String>> result = new ArrayList<>();
        int[] x;//记录每一层选中的坐标
        int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            x = new int[n];
            dfs(0);
            return result;
        }

        public void dfs(int k) {
            //k代表第几层
            if (k == n) {
                List<String> ans = new ArrayList<>();
                char[] a = new char[n];
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i < n; i++)
                        a[i] = (i == x[j] ? 'q' : '.');
                    ans.add(new String(a));
                }
                result.add(ans);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!check(i, k))
                    continue;
                x[k] = i;
                dfs(k + 1);
            }
        }

        public boolean check(int i, int k) {
            for (int j = 0; j < k; j++) {
                if (x[j] == i)
                    return false;
                int d = k - j;
                if (i == x[j] + d || i == x[j] - d)
                    return false;
            }
            return true;
        }
    }
}
