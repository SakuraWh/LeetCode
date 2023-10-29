package main.test.t2023;

import java.util.Scanner;

public class xc1 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        jc = 1;
        long min_ans = func(1, 1);
        int a = 1, b = 1;
        jc = 1 * 2;
        for (int x = 3; ; x++) {
            jc = jc * x;
            boolean change = false;
            long t = 0;
            for (int y = 3; ; y++) {
                t = func(x, y);
                if (t < min_ans) {
                    a = x;
                    b = y;
                    min_ans = t;
                    change = true;
                } else if (t > min_ans) {
                    break;
                }
            }
            if(!change){
                System.out.println(a + " " + b);
                return;
            }
        }
    }

    static long jc;

    public static long func(int x, int y) {
        long l = jc * y - y - n;
        return Math.abs(l);
    }

}
