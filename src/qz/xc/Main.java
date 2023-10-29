package qz.xc;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(i + 1);
        }
        dfs(0,arr);


    }

    static int n;
    static LinkedList<Integer> list = new LinkedList<>();
    static Set<Integer> set = new HashSet<>();

    public static boolean dfs(int begin,int[] arr) {
        if (list.size() == n) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            return true;
        }

        for (int i = 1; i <= n; i++) {
            if(!set.contains(i))
                continue;
            if(arr[begin] == i)
                continue;
            list.addLast(i);
            set.remove(i);
            boolean dfs = dfs(begin + 1, arr);
            if(dfs)
                return dfs;
            list.removeLast();
            set.add(i);
        }
        return false;
    }
}
