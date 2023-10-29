package qz.mt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(function(arr, k));
    }

    public static int function(int[] arr, int k) {
        Arrays.sort(arr);
        back(0, arr, new LinkedList<>(), arr.length - k);
        return (int) (N % 1000000007);
    }

    static long N = 0;

    public static void back(int begin, int[] arr, LinkedList<Integer> list, int k) {
        if (k == 0) {
            N++;
            return;
        }
        for (int i = begin; i < arr.length; i++) {
            if (!isListB(list, arr[i]))
                continue;
            list.addLast(arr[i]);
            back(i + 1, arr, list, k - 1);
            list.removeLast();
        }
    }

    public static boolean isListB(List<Integer> list, int x) {
        for (Integer i : list) {
            if (!isBeishu(x, i))
                return false;
        }
        return true;
    }

    public static boolean isBeishu(int x, int y) {
        return x % y == 0 || y % x == 0;
    }
}
