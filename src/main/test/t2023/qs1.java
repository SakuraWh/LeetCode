package main.test.t2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class qs1 {
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //判断位数
        int num = sc.nextInt();
        int[] dp = new int[]{912985153,534494836,472335975,146511208,88593477,24678051,24678050,9926315,9800817,4210818,1741725,548834,93084,92727,54748,9474,8208,1634,407,371,370,153};
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]<= num)
                System.out.println(dp[i]);
        }
//        String num = Integer.toString(Integer.MAX_VALUE);
//        int n = num.length();
//        int sum = Integer.parseInt(num);
//        for (int i = 2; i < n; i++) {
//            func(i, (int) Math.pow(10, i));
//        }
//        func(n,sum);
//
//        System.out.println();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i)+",");
//        }
//        // 判断符合
    }

    public static void func(int t, int up) {
        int begin = (int) Math.pow(10, t - 1);
        for (int i = begin; i < up; i++) {
            check(i,t);
        }
    }
    public static void check(int t,int k) {
        String sum = Integer.toString(t);
        int ans = 0;
        for (char c : sum.toCharArray()) {
            ans+=Math.pow(c-'0',k);
        }
        if (ans == t){
            list.addFirst(ans);
            System.out.print(ans+",");
        }


    }

}
