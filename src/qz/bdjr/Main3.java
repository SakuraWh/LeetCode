package qz.bdjr;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, hashNode> tree = new HashMap<>();
        tree.put(1, new hashNode(1, A, B, M));
        for (int i = 2; i <= n; i++) {
            tree.put(i, new hashNode(i, A, B, M));
            int t = sc.nextInt();
            tree.get(t).child.add(tree.get(i));
        }
        System.out.println(tree.get(1).getSum());

    }

    public static class hashNode {
        int val;
        int A, B, M;
        List<hashNode> child = new ArrayList<>();

        public hashNode(int v, int a, int b, int m) {
            val = v;
            A = a;
            B = b;
            M = m;
        }

        public long getSum() {
            if (child.isEmpty())
                return 0;
            long ans = 0;
            for (int i = 0; i < child.size(); i++) {
                hashNode t = child.get(i);
                long v = (t.getSum() + (long) Math.pow(A, val)) * B;
                ans += v;
            }
            return ans % M;
        }
    }
}
