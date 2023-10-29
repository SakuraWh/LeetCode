package qz.mhy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        Trr trr = new Trr();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            trr.invoke(t, x);
        }
        Double result = trr.getResult(h);
        System.out.println(result==0?"0":result);


    }

    static class Trr {
        Map<Integer, Double> hit = new HashMap<>();
        int b = 0;
        int baseHit = 0;

        Trr() {
            hit.put(0, 1.0);
        }

        public void invoke(int t, int x) {
            if (t == 1)
                addLuckyB(x);
            else
                luckyHit(x);
        }

        private void addLuckyB(int x) {
            b += x;
        }

        private void luckyHit(int x) {
            // 所有hit全拿出来，加上概率
            Map<Integer, Double> map = new HashMap<>();
            Map<Integer, Double> ggg = getGGG(b);
            b = 0;
            for (Integer a : hit.keySet()) {
                Double r = hit.get(a);
                for (Integer b : ggg.keySet()) {
                    Double t = ggg.get(b);
                    // a r  b t
                    map.put(a + b, map.getOrDefault(a + b, 0.0) + t * r);
                }
            }
            baseHit += x;
            hit = map;
        }

        public Double getResult(int h) {
            h = h - baseHit;
            double r = 0;
            for (Integer k : hit.keySet()) {
                if (k >= h)
                    r += hit.get(k);
            }
            return r;

        }

        public Map<Integer, Double> getGGG(int n) {
            Map<Integer, Double> map = new HashMap<>();
            if (n < 1) {
                return map;
            }

            int[][] p = new int[2][6 * n + 1];
            int f = 0;
            for (int i = 1; i <= 6; i++) {
                p[0][i] = 1;
            }

            for (int k = 2; k <= n; k++) {
                for (int i = 0; i < k; i++) {
                    p[1 - f][i] = 0;
                }
                for (int i = k; i <= 6 * k; i++) {
                    p[1 - f][i] = 0;
                    for (int j = 1; j <= i && j <= 6; j++) {
                        p[1 - f][i] += p[f][i - j];
                    }
                }
                f = 1 - f;

            }
            double t = Math.pow(6, n);
            for (int i = n; i <= 6 * n; i++) {
                double r = (double) p[f][i] / t;
                map.put(i, r);
            }
            return map;
        }


    }


}
