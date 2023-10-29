package qz.tx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int[] brr = new int[n - 1];
            for (int j = 0; j < n - 1; j++) {
                brr[j] = sc.nextInt();
            }
            method(n, arr, brr);
        }
    }

    public static void method(int n, int[] arr, int[] brr) {
        int[][] mapper = new int[n][2];
        for (int i = 0; i < n; i++) {
            mapper[i][0] = arr[i];
            mapper[i][1] = i + 1;
        }
        Arrays.sort(mapper, (a, b) -> a[0] - b[0]);

        int i = 0;
        do {
            float mid = getMid(arr);
            System.out.print(mid+" ");
            int t = brr[i];
            // 删除第t个
            i++;
        } while (i < n - 1);


    }

    public static float getMid(int[] arr) {
        Arrays.sort(arr);
        if ((arr.length & 1) == 1)
            return arr[arr.length / 2];
        return (arr[arr.length / 2] + arr[arr.length / 2 - 1])/2;

    }
}
