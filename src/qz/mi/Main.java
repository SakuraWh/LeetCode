package qz.mi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.next().split(",");
        int n = Integer.parseInt(split[0]);
        int r = Integer.parseInt(split[1]);

        int maxX = 0, maxY = 0;
        List<point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> t = Arrays.stream(sc.next().split(",")).map(Integer::parseInt).toList();
            int x = t.get(0);
            int y = t.get(1);
            int q = t.get(2);
            list.add(new point(x, y, q));
            maxX = Math.max(x, maxX);

            maxY = Math.max(y, maxY);
        }
        int[][] matrix = new int[maxX + r][maxY + r];
        int max = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int t = 0;
                for (point point : list) {
                    t += point.getVal(i, j);
                }
                if (t > max) {
                    max = t;
                    a = i;
                    b = j;
                }
                matrix[i][j] = t;
            }
        }
        System.out.println(a + "," + b);

    }

    static class point {
        int x, y, q;

        point(int x, int y, int q) {
            this.x = x;
            this.y = y;
            this.q = q;
        }

        public int getVal(int a, int b) {
            int v = (int) (q / (1 + getD(a, b)));
            return v;
        }

        private double getD(int a, int b) {
            return Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2));
        }
    }
}
