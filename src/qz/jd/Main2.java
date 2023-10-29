package qz.jd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE > Math.pow(10, 18));
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        String xx = Integer.toBinaryString(x);
        String yy = Integer.toBinaryString(y);
        Map<Long, List<String>> op = new HashMap<>();
    }

    public static void bfs(Map<Integer, List<String>> op, long x) {
        // 找出所有的1，然后加上这个数
        String s = Long.toBinaryString(x);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '1')
                continue;

            int t = s.length() - i - 1;
            long num = (long) Math.pow(2, t);
            long v = x + num;
            long u = x - (long) Math.pow(2, t);

        }
    }
}
