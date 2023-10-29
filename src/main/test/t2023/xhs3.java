package main.test.t2023;

import java.util.Scanner;

public class xhs3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();//操作次数
        int[] left = new int[m];//区间
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            right[i] = sc.nextInt();
        }
        String fun = sc.next(); // 操作
        int[] x = new int[m]; // 操作数
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
        }
        xhs fff = new xhs(arr);

        for (int i = 0; i < m; i++) {
            char c = fun.charAt(i);
            switch (c) {
                case '|':
                    fff.or(left[i], right[i], x[i]);
                    break;
                case '&':
                    fff.and(left[i], right[i], x[i]);
                    break;
                case '=':
                    fff.is(left[i], right[i], x[i]);
                    break;
            }
        }
        fff.show();


    }

    static class xhs {
        int[] arr;// 数组
        int len;

        public xhs(int[] arr) {
            this.arr = arr;
            len = arr.length;
        }

        public void or(int left, int right, int x) {
            for (int i = left-1; i <= right-1; i++) {
                arr[i] = arr[i] | x;
            }
        }

        public void and(int left, int right, int x) {
            for (int i = left-1; i <= right-1; i++) {
                arr[i] = arr[i] & x;
            }
        }

        public void is(int left, int right, int x) {
            for (int i = left-1; i <= right-1; i++) {
                arr[i] = x;
            }
        }

        public void show() {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
        }

    }

}
