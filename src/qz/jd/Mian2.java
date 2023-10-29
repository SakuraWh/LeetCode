package qz.jd;

import java.util.*;

public class Mian2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            Map<Integer, List<Integer>> root = new HashMap<>();
            Map<Integer, Integer> parent = new HashMap<>();
            for (int j = 0; j < n - 1; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                List<Integer> li = root.getOrDefault(a, new ArrayList<>());
                li.add(b);
                root.put(a, li);
                parent.put(b, a);
            }

            if (!root.containsKey(x)) {
                System.out.println("win");
                continue;
            }

            int k = 1;
            int xx = x;
            while (true) {
                if (!parent.containsKey(xx))
                    break;
                xx = parent.get(xx);
                k++;
            }

            int p = n - k;
            if ((p & 1) == 0) {
                System.out.println("win");
            } else
                System.out.println("lose");


        }


    }
}
