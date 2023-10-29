package main.test.t2023;

import java.util.Scanner;

public class pdd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            for (int i = 0; i < T; i++) {
                int[] dr = new int[N];
                int k = 0;
                int res = 0;
                for (int j = 0; j < N; j++) {
                    dr[j] = sc.nextInt();
                    if (dr[j] == 1)//生命值为1的敌人
                        k++;
                    //敌人总数为N，需要k/2 个A 和 N - k/2个B
                    res = k / 2 + N - k + k % 2;

                }
                System.out.println(res);
            }

        }

    }
}