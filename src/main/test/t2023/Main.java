package main.test.t2023;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a = 0;
        int min = Integer.MAX_VALUE;
        int p = -1, q = -1;
        for (int i = 0, j = 0; j < n; j++) {
            a += arr[j];
            if (min>a){ //记录最小大负值区间
                p=i;q=j;min=a;
            }
            while (a > 0) { //保证区间为负
                a = a - arr[i];
                i++;
            }
        }
        System.out.println(p+" "+q +" "+min);


    }
}
