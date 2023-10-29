package main.test.t2023;

import java.util.Scanner;

public class xhs1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //char[] str = new char[N];
        String S = sc.next();
        //int i = 0;
        for (char c : S.toCharArray()) {
            System.out.print(suc(c));
        }

    }

    public static char suc(char x) {
        int t = x - 'a';
        t = (t - 3 + 26) % 26;
        return (char) (t + 'a');
    }
}
