package main.test.t2023;

import java.util.Scanner;

public class xc2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 让最大的k个数放在前面
        int begin = n - k +1;
        for (int i = 1; i <= n - k; i++) {
            if(begin <= n)
                System.out.print(begin++ +" ");
            System.out.print(i+" ");
        }
        if (begin == n)
            System.out.print(begin+" ");
    }
}
