package main.test.t2023;

import java.util.Scanner;

public class bd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                String s = sc.next();
                System.out.println(isBd(s) ? "True" : "False");
            }
        }
    }

    public static boolean isBd(String s) {
        if (s.length() != 5)
            return false;
        boolean baidu[] = new boolean[5];
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'B':
                    baidu[0] = true;
                    break;
                case 'a':
                    baidu[1] = true;
                    break;
                case 'i':
                    baidu[2] = true;
                    break;
                case 'd':
                    baidu[3] = true;
                    break;
                case 'u':
                    baidu[4] = true;
                    break;
            }
        }
        for (boolean b : baidu) {
            if (!b)
                return false;
        }
        return true;

    }
}
