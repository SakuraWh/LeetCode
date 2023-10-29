package qz.kdxf;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = 1;
        int y = 1;
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                for (int j = 0; j < m - 1; j++) {
                    str.append("D");
                }
            } else {
                for (int j = 0; j < m - 1; j++) {
                    str.append("A");
                }
            }
            if (i < n - 1)
                str.append("S");
        }
        System.out.printf("%d %d\n", x, y);
        System.out.println(str);
    }
}
