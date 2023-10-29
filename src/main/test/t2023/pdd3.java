package main.test.t2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pdd3 {


    public static void main(String[] args) {
        new soulation().func();


    }
    static class soulation {
        int can; // 能处理的人
        int cost_res; //花费的金额
        boolean flag = true;

        public void func() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int N = scanner.nextInt();
                List<int[]> hd = new ArrayList<>();
                int single[] = new int[3];
                int three = 0;
                for (int i = 0; i < N; i++) {
                    String next = scanner.next();
                    if (next.length() == 1) {
                        single[next.charAt(0) - 'A']++;
                        continue;
                    } else if (next.length() == 3){
                        three++;
                        continue;
                    }

                    //长度为2的选项
                    int[] t = new int[next.length()];
                    for (int j = 0; j < next.length(); j++) {
                        t[j] = next.charAt(j) - 'A';
                    }
                    hd.add(t);
                }
                int[] sum = new int[3];
                int[] cost = new int[3];
                for (int i = 0; i < 3; i++) {
                    sum[i] = scanner.nextInt();
                    cost[i] = scanner.nextInt();
                }
                can = 0;
                cost_res = 0;
                flag = true;

                single_func(sum, cost, single);
                two_func(sum, cost, hd);
                three_func(sum, cost, three);
                if (flag) {
                    System.out.println("YES\n" + cost_res);
                } else {
                    System.out.println("NO\n" + can);
                }
            }
        }

        public void two_func(int[] sum, int[] cost, List<int[]> list) {
            //优先排进去 -> 选sum多的，相同选cost多的
            for (int[] ints : list) {
                int a = ints[0], b = ints[1];
                if (sum[a] == sum[b]) {
                    if (sum[a] == 0) {
                        flag = false;
                        continue;//满了
                    }
                    if (cost[a] > cost[b]) {
                        sum[b]--;
                        cost_res += cost[b];
                    } else {

                        sum[a]--;
                        cost_res += cost[a];
                    }
                    can++;
                } else if (sum[a] > sum[b]) {
                    if (sum[a] == 0) {
                        flag = false;
                        continue;//满了
                    }
                    sum[a]--;
                    cost_res += cost[a];
                    can++;
                } else {
                    if (sum[b] == 0) {
                        flag = false;
                        continue;//满了
                    }
                    sum[b]--;
                    cost_res += cost[b];
                    can++;
                }
            }

        }

        public void single_func(int[] sum, int[] cost, int[] single) {
            // 将单人处理了
            for (int i = 0; i < 3; i++) {
                if (sum[i] >= single[i]) {
                    //能处理
                    cost_res += cost[i] * single[i];
                    can += single[i];
                    sum[i] = sum[i] - single[i];
                } else {
                    // 超出范围
                    flag = false;
                    cost_res += sum[i] * cost[i];
                    can += sum[i];
                    sum[i] = 0;
                }
            }
        }

        public void three_func(int[] sum, int[] cost, int three) {
            //选有货便宜的
            int cheap = 0;
            int min = cost[0];

            for (int i = 1; i < 3; i++) {
                if (min > cost[i]) {
                    min = cost[i];
                    cheap = i;
                }
            }
            if (three > sum[cheap]) {
                cost_res += sum[cheap] * cost[cheap];
                can += sum[cheap];
                three = three - sum[cheap];
            } else if (sum[cheap] == three) {
                cost_res += sum[cheap] * cost[cheap];
                can += sum[cheap];
                return;
            } else {
                cost_res += three * cost[cheap];
                can += three;
                return;
            }
            int a = 0, b = 0;
            switch (cheap) {
                case 0:
                    a = 1;
                    b = 2;
                    break;
                case 1:
                    a = 0;
                    b = 2;
                    break;
                case 2:
                    a = 0;
                    b = 1;
                    break;
            }
            if (cost[a] > cost[b]) {
                //选小的 b
                cheap = b;
                if (three > sum[cheap]) {
                    cost_res += sum[cheap] * cost[cheap];
                    can += sum[cheap];
                    three = three - sum[cheap];
                } else if (sum[cheap] == three) {
                    cost_res += sum[cheap] * cost[cheap];
                    can += sum[cheap];
                    return;
                } else {
                    cost_res += three * cost[cheap];
                    can += three;
                    return;
                }
                cheap = a;
                if (three > sum[cheap]) {
                    cost_res += sum[cheap] * cost[cheap];
                    can += sum[cheap];
                    three = three - sum[cheap];
                } else if (sum[cheap] == three) {
                    cost_res += sum[cheap] * cost[cheap];
                    can += sum[cheap];
                    return;
                } else {
                    cost_res += three * cost[cheap];
                    can += three;
                    return;
                }

            } else {
                cheap = a;
                if (three > sum[cheap]) {
                    cost_res += sum[cheap] * cost[cheap];
                    can += sum[cheap];
                    three = three - sum[cheap];
                } else if (sum[cheap] == three) {
                    cost_res += sum[cheap] * cost[cheap];
                    can += sum[cheap];
                    return;
                } else {
                    cost_res += three * cost[cheap];
                    can += three;
                    return;
                }
                cheap = b;
                if (three > sum[cheap]) {
                    cost_res += sum[cheap] * cost[cheap];
                    can += sum[cheap];
                    three = three - sum[cheap];
                } else if (sum[cheap] == three) {
                    cost_res += sum[cheap] * cost[cheap];
                    can += sum[cheap];
                    return;
                } else {
                    cost_res += three * cost[cheap];
                    can += three;
                    return;
                }
            }
        }
    }

}



