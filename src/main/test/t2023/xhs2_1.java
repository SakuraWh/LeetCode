package main.test.t2023;

import java.util.*;

public class xhs2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        String color = sc.next();
        List<ball> list = new ArrayList<>();
        pkg pk = new pkg();
        for (int i = 0; i < color.length(); i++) {
            ball ball = new ball(color.charAt(i), arr[i]);
            list.add(ball);
        }


        int k = sc.nextInt();
        int[] time = new int[k];
        for (int i = 0; i < k; i++) {
            time[i] = sc.nextInt();
        }
        pk.time = time[0];


        for (int i = 0; i < k; i++) {
            int m = sc.nextInt();
            if (m == 0) {
                pk.Get(time[i]);
            } else if (m < 0) {
                pk.Remove(list.get(-m - 1), time[i]);
            } else {
                pk.Add(list.get(m - 1), time[i]);
            }
        }
    }

    public static class pkg {
        public Set<ball> balls;
        public int time;

        public pkg() {
            balls = new HashSet<>();
            time = 0;
        }

        public void Add(ball b, int t) {

            balls.add(b);
            once(t);

        }

        public void Remove(ball b, int t) {

            balls.remove(b);
            once(t);

        }

        public void Get(int t) {

            int res = 0;

            for (ball ball : balls) {
                res += ball.num;
            }
            System.out.print(res + " ");
            once(t);

        }

        public void once(int end) {
            for (ball ball : balls) {
                ball.once(end - time);
            }
            time = end;
        }
    }

    public static class ball {
        public int color;
        public int num;

        public ball(char c, int num) {
            color = (c == 'R' ? 1 : -1);
            this.num = num;
        }

        public void once(int t) {
            num = num + color * t;
        }
    }
}

