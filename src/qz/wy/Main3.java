package qz.wy;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i1 = 0; i1 < n; i1++) {
                arr[i1] = in.nextInt();
            }
            System.out.println(function(arr) ? "YES" : "NO");
        }

    }

    public static boolean function(int[] arr) {
        if ((arr.length & 1) == 1)
            return true;
        return false;
    }
}
