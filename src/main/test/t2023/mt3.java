package main.test.t2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小美是一位天文爱好者，她收集了接下来一段时间中所有会划过她所在的观测地上空的流星信息。具体地，她收集了n个流星在她所在观测地上空的出现时刻和消失时刻。对于一个流星，若其的出现时刻为s，消失时刻为t，那么小美在时间段[s, t]都能够观测到它。对于一个时刻，观测地上空出现的流星数量越多，则小美认为该时刻越好。小美希望能够选择一个最佳的时刻进行观测和摄影，使她能观测到最多数量的流星。现在小美想知道，在这个最佳时刻，她最多能观测到多少个流星以及一共有多少个最佳时刻可供她选择。
 */
public class mt3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] ints = new int[2];
                list.add(ints);
                ints[0] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                list.get(i)[1] = scanner.nextInt();
            }


        }
    }

    public void test(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int max = 0;
            int n = scanner.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] ints = new int[2];
                list.add(ints);
                ints[0] = scanner.nextInt();
                max = Math.max(max, ints[0]);
            }
            for (int i = 0; i < n; i++) {
                list.get(i)[1] = scanner.nextInt();
                max = Math.max(max, list.get(i)[1]);
            }
            int[] pen = new int[max + 1];
            max = 0;
            for (int[] ints : list) {
                for (int i = ints[0]; i <= ints[1]; i++) {
                    pen[i]++;
                    max = Math.max(max, pen[i]);
                }
            }
            int t = 0;
            for (int i = 0; i < pen.length; i++) {
                if (pen[i] == max)
                    t++;
            }
            System.out.println(max + " " + t);

        }
    }
}
