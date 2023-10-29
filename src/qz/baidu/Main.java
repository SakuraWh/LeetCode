package qz.baidu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                check(n, m);
            }
        }
    }

    public static void check(int n, int m) {
        if ((n & 1) == 1 && (m & 1) == 1)
            System.out.println("No");
        else if ((n & 1) == 0 && (m & 1) == 0)
            System.out.println("No");
        else
            System.out.println("Yes");
    }
}
