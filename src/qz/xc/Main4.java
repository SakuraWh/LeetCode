package qz.xc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            matrix[i] = s.toCharArray();
        }
        System.out.println(count(matrix));

    }

    public static int count(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int x = 0; x < m; x++) {
                    for (int y = x; y < m; y++) {

                        char[][] temp = new char[j-i+1][y-x+1];
                        Map<Character,Integer> cc = new HashMap<>();
                        for (int k = i; k <= j; k++) {
                            for (int l = x; l <= y; l++) {
                                char c =  matrix[k][l];
                                temp[k-i][l-x] = c;
                                cc.put(c,cc.getOrDefault(c,0)+1);
                            }
                        }
                        boolean vaild = true;
                        for (Character c : cc.keySet()) {
                            if(cc.get(c)>1){
                                vaild = false;
                                break;
                            }
                        }
                        if(vaild)
                            count++;
                    }
                }
            }
        }
        return count;

    }
}
