package qz.kdxf;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char c = 'a';
        if (n == k) {
            System.out.println(-1);
            return;
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < n - k; i++) {
            str.append("a");
        }
        c++;
        for (int i = 0; i < k; i++) {
            if(c>'z'){
                System.out.println(-1);
                return;
            }
            str.append(c);
            c++;
        }
        System.out.println(str);

    }
}
