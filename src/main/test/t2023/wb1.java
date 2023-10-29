package main.test.t2023;

import java.util.Scanner;

/**
 *
 */
public class wb1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            int L, R, X, Y;
            L = sc.nextInt();
            R = sc.nextInt();
            X = sc.nextInt();
            Y = sc.nextInt();
            // 执行区间 L个1在最低位，R个1在最高位
            // -1表示为止，1表示
            int res = 0;
            //for (int j = 0; j < 4; j++) {
            // res = 0;
            for (int k = X; k <= Y; k++) {
                int r = getzh(k);
                if (r >= L && r <= R && (k & X) == X && (k | Y) == Y) {
                    res++;
                }
            }
            //}
            System.out.println(res);


//            int use = 32;
//            int[] res = new int[32];
//            for (int j = 0; j < 32; j++) {
//                res[j] = -1;
//            }
//            int[] xx = GetBinary(X);
//            int[] yy = GetBinary(Y);
//            int one = 0;
//            for (int j = 0; j < 32; j++) {
//                if (xx[j] == 1) {
//                    res[j] = 1;
//                    use--;
//                    one++;
//                }
//                if (yy[j] == 0) {
//                    res[j] = 0;
//                    use--;
//                }
//            }
//            int result = 0;
//            for (int j = L - one; j <= R - one; j++) {
//                if (use < j)
//                    break;
//                int c = 1;
//                int p = use;
//                for (int k = 0; k < j; k++) {
//                    c = p * c;
//                    p--;
//                }
//                int cx = 1;
//                for (int k = j; k > 0; k--) {
//                    cx = cx * k;
//                }
//                result = result + (c / cx);
//            }
//            System.out.println(result);
        }
    }

    public static int[] GetBinary(int number) {
        char[] array = Integer.toBinaryString(number).toCharArray();
        int[] res = new int[32];
        int k = 31;
        for (int i = array.length - 1; i >= 0; i--) {
            res[k--] = array[i] - '0';
        }
        return res;
    }

    public static int getzh(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                res++;
        }
        return res;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            int value = 0;
//            for (int j = i; j < n; j++) {
//                value += arr[i];
//                dp[i][j] = value;
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        int p=0,q=0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + " ");
//                if (min>dp[i][j]){
//                    min = dp[i][j];
//                    p=i;
//                    q=j;
//                }
//            }
//            System.out.println();
//        }
//        System.out.println(min+" "+p+" "+q);
//
//
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int a = 0;
//        int min = Integer.MAX_VALUE;
//        int p = -1, q = -1;
//        for (int i = 0, j = 0; j < n; j++) {
//            a += arr[j];
//            if (min>a){ //记录最小大负值区间
//                p=i;q=j;min=a;
//            }
//            while (a > 0) { //保证区间为负
//                a = a - arr[i];
//                i++;
//            }
//        }
//        System.out.println(p+" "+q +" "+min);
//
//
//    }

}
