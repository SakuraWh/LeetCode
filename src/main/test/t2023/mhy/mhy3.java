package main.test.t2023.mhy;

import java.util.*;

public class mhy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        Map<Integer, Boolean> use = new HashMap<>();
        List<Integer> delete = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if (map.get(integer) < k){
                delete.add(integer);
            }
            else
                use.put(integer, false);
        }
        for (Integer key : delete) {
            map.remove(key);
        }
        dfs(new LinkedList<>(), use, map, k);
        System.out.println(count);
    }

    static int count = 0;

    public static void dfs(LinkedList<Integer> now, Map<Integer, Boolean> use, Map<Integer, Integer> map, int k) {
        if (now.size() > map.size())
            return;
        if (now.size() != 0) {
            int ans = 1;
            for (Integer kr : now) {
                Integer num = map.get(kr);
                ans *= getC(num, k);
            }
            count += ans;
        }
        for (Integer key : map.keySet()) {
            if (use.get(key))
                continue;
            now.addLast(key);
            use.put(key,true);
            dfs(now, use, map, k);
            use.put(key,false);
            now.removeLast();
        }
    }

    public static int getC(int n, int k) {
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= (n - i);
        }
        for (int i = k; i > 0; i--) {
            res /= i;
        }
        return res;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] b = new int[n-1];
//        for (int i = 0; i < n - 1; i++) {
//            b[i] = sc.nextInt();
//            if (i > 0) {
//                b[i] = b[i] - b[i - 1];
//            }
//        }
//        int count = 0;
//        for (int i = 1; i < b[0]; i++) {
//            int flag = 0;
//            if (i % 2 == 0 ) {
//                if (b[i] - i > 0)
//                    count++;
//            }else{
//                if (b[i] + i > 0)
//                    count++;
//            }
//        }
//        System.out.println(count);
//    }
}
