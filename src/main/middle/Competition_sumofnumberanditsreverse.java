package main.middle;

import java.util.LinkedList;
import java.util.List;

public class Competition_sumofnumberanditsreverse {
    class Solution {
        public boolean sumOfNumberAndReverse(int num) {
            for (int i = 1; i < num - 1; i++) {
                int re = num - i;
                if (check(re,i))
                    return true;
            }
            return false;
        }

        public boolean check(int x, int y) {
            int t = 0;
            if (x > y) {
                t = convert(x);
                if (t == y)
                    return true;
            } else {
                t = convert(y);
                if (t == x)
                    return true;
            }
            return false;

        }

        public int convert(int a) {
            List<Integer> list = new LinkedList<>();
            while (a > 0) {
                list.add(a % 10);
                a /= 10;
            }
            int ans = 0;
            while (!list.isEmpty()) {
                ans *= 10;
                ans += list.remove(0);
            }
            return ans;
        }

    }
}
