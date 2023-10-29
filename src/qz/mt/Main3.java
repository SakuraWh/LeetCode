package qz.mt;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int k = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                k = i;
            }
        }
        if (k == 0) {
            System.out.println(0);
            return;
        }


        int f = 0;
        long m = arr[0];
        while (m < max) {
            m = m * 2;
            f++;
        }
        System.out.println(f);


    }
}
