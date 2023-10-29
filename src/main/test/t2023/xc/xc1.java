package main.test.t2023.xc;

import java.util.Scanner;

public class xc1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            arr[i] = next.toCharArray();
        }
        int res =0;
        for (int i = 1; i < n; i++) {

            int y=0,o=0,u=0;

            switch (arr[i-1][0]){
                case 'y':y++;break;
                case 'o':o++;break;
                case 'u':u++;break;
            }
            switch (arr[i][0]){
                case 'y':y++;break;
                case 'o':o++;break;
                case 'u':u++;break;
            }

            for (int j = 1; j < m; j++) {
                switch (arr[i-1][j]){
                    case 'y':y++;break;
                    case 'o':o++;break;
                    case 'u':u++;break;
                }
                switch (arr[i][j]){
                    case 'y':y++;break;
                    case 'o':o++;break;
                    case 'u':u++;break;
                }
                if (y>=1&&o>=1&&u>=1)
                    res++;
                switch (arr[i-1][j-1]){
                    case 'y':y--;break;
                    case 'o':o--;break;
                    case 'u':u--;break;
                }
                switch (arr[i][j-1]){
                    case 'y':y--;break;
                    case 'o':o--;break;
                    case 'u':u--;break;
                }
            }
        }
        System.out.println(res);
    }
}
