package qz.kdxf;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int t = 0;
            for (char c : Integer.toString(x).toCharArray()) {
                t += (c == '0' ? 1 : 0);
            }
            count += Integer.toString(x).length() - t;
        }
        System.out.println(count);

    }
}
