package main.middle;

import java.util.*;

public class test_factorcombinations {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> cur = new LinkedList<>();

    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2);
        return list;
    }

    public void dfs(int n, int x) {
        if (!cur.isEmpty()) {
            cur.addLast(n);
            list.add(new LinkedList<>(cur));
            cur.removeLast();
        }
        for (int i = x; i * i <= n; i++) {
            if (n % i == 0) {
                cur.addLast(i);
                dfs(n/i,i);
                cur.removeLast();
            }
        }
    }
}
