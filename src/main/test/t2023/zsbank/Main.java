package main.test.t2023.zsbank;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int N = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Integer[] b = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            b[x-1] = y;
            Arrays.sort(b,Collections.reverseOrder());
            int count = 0;
            for (int j = 0; j <N; j++) {
                count+=(j+1)*b[j];
            }
            System.out.println(count);
        }
    }
}
