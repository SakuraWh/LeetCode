package main.test.t2023.tencentcloud;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main1 {

    List<List<Integer>> res = new ArrayList<>();
    int width = 0;
    public int[][] combination(int k, int n) {
        this.k=k;
        this.n=n;
        dfs(1, 0);

        int[][] resmat = new int[res.size()][k];
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < k; j++) {
                resmat[i][j] = res.get(i).get(j);
            }
        }
        return resmat;

    }

    int n;
    int k;
    LinkedList<Integer> list = new LinkedList<>();

    public void dfs(int begin, int sum) {
        if (sum == n && k == list.size()) {
            res.add(new ArrayList<>(list));
        }
        if (list.size() >= k)
            return;
        if (sum >= n)
            return;
        for (int i = begin; i < 10; i++) {
            list.addLast(i);
            dfs(i + 1, sum + i);
            list.removeLast();
        }
    }
}
