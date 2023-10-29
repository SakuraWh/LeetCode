package qz.xc;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] aCopy = Arrays.copyOf(arr, n);
        Arrays.sort(aCopy);
        for (int i = 1; i <= n; i++) {
            if (i < n && arr[i - 1] == aCopy[i - 1]) {
                int t = aCopy[i - 1];
                aCopy[i - 1] = aCopy[i];
                aCopy[i] = t;// swap
            }
            if (i == n && arr[i - 1] == aCopy[i - 1]){
                int t = aCopy[i - 1];
                aCopy[i - 1] = aCopy[i-2];
                aCopy[i-2] = t;// swap
            }
        }
        for (int i : aCopy) {
            System.out.print(i+" ");
        }
    }
}
