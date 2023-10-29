package main.test.t2023;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class pdd4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] ke = new int[N];
            for (int i = 0; i < N; i++) {
                ke[i] = scanner.nextInt();
            }

            //计算平均值
            int[] sum = new int[N];
            for (int i = 0; i < N; i++) {
                sum[i] = (i > 0 ? sum[i - 1] : 0) + ke[i];
                float v = (float) sum[i] / (i + 1);
                //对v进行四舍五入
                System.out.print((v - (int) v >= 0.5 ? (int) v + 1 : (int) v) + " ");
            }
            System.out.println();
            //计算中位数
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int j = 0;
                while (j < list.size() && ke[i] > list.get(j))
                    j++;
                list.add(j, ke[i]);
                //超时
                int res;
                if (list.size() % 2 == 1) {
                    res = list.get(list.size() / 2);
                } else {
                    res = list.get(list.size() / 2) + list.get(list.size() / 2 - 1);
                    float v = (float) res / 2;
                    res = (v - (int) v >= 0.5 ? (int) v + 1 : (int) v);
                }
                System.out.print(res + " ");
            }
            System.out.println();


        }
    }
}
