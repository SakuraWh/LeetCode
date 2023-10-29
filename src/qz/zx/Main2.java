package qz.zx;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int t = k;
        int i = 0;
        for (char c : str.toCharArray()) {
            i++;
            if (n == 0)
                break;
            if (c == '0') {
                if (t != k) {
                    n--;
                    t = k;
                }
                continue;
            }
            t--;
            if (t == 0) {
                n--;
                t = k;
            }
        }

        int count = 0;
        if(i==str.length()){
            System.out.println(count);
            return;
        }

        for (int j = i-1; j < str.length(); j++) {
            if (str.charAt(j) == '1')
                count++;
        }
        System.out.println(count);

    }
}
