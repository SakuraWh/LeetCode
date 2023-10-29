package qz.tx.second;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] S = new int[n];
        int[] V = new int[n];
        for (int i = 0; i < n; i++)
            S[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            V[i] = sc.nextInt();

        // 获取排名
        Map<Integer, Integer> begin = getSort(S);

        for (int i = 0; i < n; i++) {
            S[i] += t * V[i];
        }

        Map<Integer, Integer> end = getSort(S);
        int ans = 0;
        for (Integer p : begin.keySet()) {
            if (end.get(p) > begin.get(p))
                ans++;
        }
        System.out.println(ans);

    }

    public static Map<Integer, Integer> getSort(int[] S) {
        Map<Integer, Integer> map = new HashMap<>();


        Map<Integer, Integer> cj = new HashMap<>();//成绩排名
        int n = S.length;

        int[] t = S.clone();
        Arrays.sort(t);


        for (int i = n - 1; i >= 0; i--) {
            if (!cj.containsKey(t[i])) {
                cj.put(t[i], cj.size());
            }
        }
        for (int i = 0; i < n; i++) {
            map.put(i, cj.get(S[i]));
        }


        return map;
    }
}
