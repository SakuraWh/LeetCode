package qz.mhy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        int suma = 0;
        int sumb = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            suma += x;
            a.add(x);
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sumb += x;
            b.add(x);
        }

        int max = Integer.MIN_VALUE;
        for (Integer x : a) {
            int t = suma - x;
            max = Math.max(max, t ^ sumb);
        }
        for (Integer x : b) {
            int t = sumb - x;
            max = Math.max(max, t ^ suma);
        }
        System.out.println(max);

    }
}
