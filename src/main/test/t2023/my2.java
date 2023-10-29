package main.test.t2023;

import java.math.BigDecimal;
import java.util.*;

public class my2 {
    public static void main(String[] args) {
        //System.out.println(1000000000>Integer.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            n = sc.nextInt();//零件个数
            x = sc.nextInt();//最大预算
            price = new ArrayList<>();
            value = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();//零件型号
                int[] p = new int[m];
                int[] v = new int[m];
                for (int j = 0; j < m; j++) {
                    p[j] = sc.nextInt();//价格
                }
                for (int j = 0; j < m; j++) {
                    v[j] = sc.nextInt();//性能
                }
                int[][] t = new int[2][];
                t[0] = p;
                t[1] = v;
                Arrays.sort(t, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0]-o2[0] == 0)
                            return o2[1]-o1[1];
                        return o1[0]-o2[0];
                    }
                });
                price.add(p);
                value.add(v);
            }
            deep = 0;
            res = -1;
            dfs(0, x, 0);
            System.out.println(res);

        }
    }

    static int n;
    static int x;
    static List<int[]> price;
    static List<int[]> value;
    static int deep;
    static int res;

    public static void dfs(int t, int x, int vmax) {
        if (x < 0)
            return;
        if (t >= n) {
            if (deep == n)
                res = Math.max(res, vmax);
            return;
        }
        int[] p = price.get(t);
        int[] v = value.get(t);
        for (int i = 0; i < v.length; i++) {
            deep++;
            dfs(t + 1, x - p[i], vmax + v[i]);
            deep--;
        }
    }
}
