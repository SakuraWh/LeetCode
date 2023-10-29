package main.test.t2023.tencentcloud;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        if(n==1){
            System.out.println(arr[0]);
            return;
        }else if(n==2){
            System.out.println(Math.max(arr[0],arr[1]));
            return;
        }


        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1],dp[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        System.out.println(dp[dp.length-1]);
    }
}
