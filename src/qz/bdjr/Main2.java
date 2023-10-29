package qz.bdjr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<colorNode> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new colorNode());
        }

        for (int i = 1; i < n; i++) {
            int t = sc.nextInt();
            list.get(t - 1).setChild(list.get(i));
        }
        for (int i = 0; i < n; i++) {
            list.get(i).color = sc.nextInt();
        }
        System.out.println(list.get(0).getSum());


    }

    public static class colorNode {
        public int val;
        public int color;
        public static final int RED = 2;
        public static final int BLUE = 1;
        public colorNode left;
        public colorNode right;

        colorNode() {
            val = 1;
        }

        public void setChild(colorNode node) {
            if (left == null) {
                left = node;
                return;
            }
            right = node;
        }

        public long getSum() {
            if (left == null && right == null)
                return 1;
            long ans = 0;
            if (color == RED)
                ans = left.getSum() * right.getSum();
            else if (color == BLUE)
                ans = left.getSum() + right.getSum();
            return ans % 1000000007;
        }
    }
}
