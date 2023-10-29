package main.test.t2023.zsbank;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int N = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            list.add(new int[]{i + 1, t});
        }
        list.sort((a, b) -> b[1] - a[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i)[0], i);
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i)[1];
            sum += (i + 1) * a;
        }


        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int count = sum;
            int index = map.get(x);
            int c = list.get(index)[1];
            int cz = c * (index + 1);
            count = count - cz;
            int j = index+1;
            for (;j<list.size()&& list.get(j)[1] > y; j++) {
                if (j == index)
                    continue;
                count = count - list.get(j)[1];
            }
            count += y * j;
            System.out.println(count);
        }
    }
}
