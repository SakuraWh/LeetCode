package main.test.t2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tx5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum*=arr[i];
        }
        dfs(0,sum,new ArrayList<>(),arr,k);
        System.out.println(ans);


    }

    static int ans = 0;

    public static void dfs(int begin, int weight, List<Integer> list, int[] arr, int k) {
        if (begin > arr.length)
            return;
        if (weight < k)
            return;
        if (weight == k){
            ans++;

        }


        for (int i = begin; i < arr.length; i++) {
            list.add(arr[i]);
            int w = MAX(weight,arr[i]);
            // w更和新插入的数字计算最小公倍数
            dfs(i + 1,w, list, arr, k);
            list.remove(list.size() - 1);
        }
    }

    public static int MAX(int a, int b) {
        int temp = a < b ? a : b;
        while (temp > 0) {
            if (a % temp == 0 && b % temp == 0)
                break;
            temp--;
        }
        return temp;
    }
}
