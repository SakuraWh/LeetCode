package qz.mt;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int x = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] <= x) {
                System.out.println("No");
                return;
            }
            x = arr[i];
        }
        int[] ans = new int[n-1];
        for (int i = 0; i < arr.length-1; i++) {
            ans[i] = arr[i+1]-arr[i];
        }
        for (int i = 1; i < ans.length; i++) {
            if(ans[i]>=ans[i-1]){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");


    }
}