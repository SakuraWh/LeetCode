package main.test.t2023;

import java.util.Scanner;

public class tx3 {
    public static int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // 枚举所有可能的子数组
        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            if (gcd == k) {
                count++;
            }
            for (int j = i + 1; j < n; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == k) {
                    count++;
                }
            }

            // 假设当前元素为无用元素，计算剩下的元素的最大公约数是否等于k
            if (nums[i] != k) {
                int[] remaining = new int[n - 1];
                int index = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        remaining[index++] = nums[j];
                    }
                }
                if (gcd(remaining, k)) {
                    count++;
                }
            }
        }
        return count;
    }

    // 计算整数数组的最大公约数
    private static boolean gcd(int[] nums, int k) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = gcd(result, nums[i]);
        }
        return (result == k);
    }

    // 计算两个整数的最大公约数
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

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
        System.out.println(countSubarrays(arr, k));

    }
}
