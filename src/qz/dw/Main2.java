package qz.dw;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int maxLen = 0;
        for (int i = 0, j = 0; j < str.length(); j++) {
            if(is110(str,j)){
                i=j-1;
            }
            maxLen = Math.max(maxLen,j-i+1);
        }
        System.out.println(maxLen);
    }

    public static boolean is110(String s, int j) {
        if (j < 2)
            return false;
        return s.charAt(j - 2) == '1' && s.charAt(j - 1) == '1' && s.charAt(j) == '0';
    }
}
