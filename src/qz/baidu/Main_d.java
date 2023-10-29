package qz.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= m; i++) {
            b[i] = sc.nextInt();
        }

        int result = function(m, n, a, b);
        System.out.println(result);
    }

    public static int function(int m, int n, int[] arr, int[] brr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int len = Integer.MAX_VALUE;
        for (int r = 1, l = 1; r < arr.length; r++) {
            while (canMoveLeft(brr, countMap)) {
                len = Math.min(r - l, len);
                countMap.put(arr[l], countMap.getOrDefault(arr[l], 0) - 1);
                l++;
            }
            countMap.put(arr[r], countMap.getOrDefault(arr[r], 0) + 1);
            // 判断能否符合要求
        }
        return len;
    }

    public static boolean canMoveLeft(int[] brr, Map<Integer, Integer> map) {
        for (int i = 0; i < brr.length; i++) {
            int x = map.getOrDefault(i, 0);
            if (x < brr[i])
                return false;
        }
        return true;
    }

}
