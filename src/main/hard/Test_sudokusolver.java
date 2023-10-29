package main.hard;

import java.util.*;

public class Test_sudokusolver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] a = new char[][]{
                {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
                {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
                {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
                {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
                {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
                {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
                {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
                {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
                {'0', '0', '0', '0', '8', '0', '0', '7', '9'}
        };

        solution.solveSudoku(a);

    }

    static class Solution {
        int[][] result;
        int[][] path = new int[9][9];
        List<int[]> list = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++) {
                    path[i][j] = (board[i][j] == '.' ? 0 : board[i][j] - '0');
                    if (path[i][j] == 0)
                        list.add(new int[]{i, j});//待填空位
                }

            dfs(0);
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++) {
                    board[i][j] = (char) (path[i][j] + '0');
                }

        }


        public void dfs(int k) {
            if (k == list.size()) {
                //填满了，加入到结果集;
                result = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        result[i][j] = path[i][j];
                    }
                }
                return;
            }
            int[] dot = list.get(k);
            int x = dot[0];
            int y = dot[1];
            for (int i = 1; i <= 9; i++) {
                if (!check(x, y, i))//减枝
                    continue;
                path[x][y] = i;
                dfs(k + 1);
                if (result != null)//减枝
                    return;
                path[x][y] = 0;

            }
        }

        public boolean check(int x, int y, int k) {
            for (int i = 0; i < 9; i++) {
                if (path[i][y] == k)
                    return false;
                if (path[x][i] == k)
                    return false;
            }
            int a = x / 3 * 3;
            int b = y / 3 * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (path[a + i][b + j] == k)
                        return false;
                }
            }
            return true;
        }
    }
}
