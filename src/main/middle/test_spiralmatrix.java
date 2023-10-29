package main.middle;

import java.util.ArrayList;
import java.util.List;

public class test_spiralmatrix {
    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = new test_spiralmatrix().spiralOrder(ints);
        for (Integer integer : list) {
            System.out.printf("%d ", integer);
        }
    }

    int[][] next = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    int i = 0, j = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 走过的地方就不走了
        int count = matrix.length * matrix[0].length;
        int to = 0;
        while (count > 0) {
            res.add(matrix[i][j]);
            matrix[i][j] = Integer.MIN_VALUE;
            if (!checkNext(matrix, to)) {
                to = (to + 1) % 4;
            }
            toNext(to);
            count--;
        }
        return res;
    }

    public void toNext(int to) {
        i += next[to][0];
        j += next[to][1];
    }

    public boolean checkNext(int[][] matrix, int to) {
        int x = i + next[to][0];
        int y = j + next[to][1];
        if (x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0)
            return false;
        if (matrix[x][y] == Integer.MIN_VALUE || matrix[x][y] == Integer.MIN_VALUE
                || matrix[x][y] == Integer.MIN_VALUE || matrix[x][y] == Integer.MIN_VALUE)
            return false;
        return true;
    }

}
