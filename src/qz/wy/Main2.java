package qz.wy;

import java.math.BigDecimal;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        dfs(arr, 0, 0, 0);
//        map.remove(0);
        Map<Long, Long> mp = new HashMap<>();
        int end = n * 2;
        for (int i = 0; i < end; i++) {
            boolean isN = true;
            List<Integer> tmp = new ArrayList<>();
            long t = 0;
            for (int j = 0; j < n; j++) {
                if ((1 << j & i) != 0) {
                    isN = false;
                    tmp.add(arr[j]);
                    t += arr[j];
                }
            }
            if (!tmp.isEmpty()) {
                long size = tmp.size();
                mp.put(size, (t + mp.getOrDefault(size, 0L)) % mod);
            }
        }

        long res = 0;
        for (long t : mp.keySet()) {
            Long p = mp.get(t);
            long rm = (p * pow(t, mod - 2)) % mod;
            res = (res + rm) % mod;
        }

        System.out.println(res);


    }

    static int mod = 1000000007;



    static long pow(long x, long k) {
        x %= mod;
        long ans = 1;
        while (k > 0) {
            if ((k & 1) == 0)
                ans = (ans * x) % mod;
            x = (x * x) % mod;
            k >>= 1;
        }
        return ans;
    }
}