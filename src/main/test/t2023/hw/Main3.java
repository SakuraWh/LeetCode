package main.test.t2023.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        //List<List<Integer>> cao = new ArrayList<>()
        int[][] cao = new int[n+1][n];
        int[] num = new int[10000];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                cao[i][j] = Math.max(Math.abs(x[i]-x[j]),Math.abs(y[i]-y[j]));
                System.out.print(cao[i][j]+" ");
                num[cao[i][j]/2]++;
            }
            System.out.println();
        }
        int res = 0;
        for (int i = 0; i < 10000; i++) {
            res+=num[i];
            if(res>=M){
                System.out.println(i);
                return;
            }
        }
    }
}
