package main.test.t2023.hw2;

import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        String[] num = s.split("\\+");

        String[] numm1 = num[0].split("\\.");
        String[] numm2 = num[1].split("\\.");
        String a1, a2, b1, b2;
        a1 = numm1[0];
        a2 = numm1.length < 2 ? "0" : numm1[1];
        b1 = numm2[0];
        b2 = numm2.length < 2 ? "0" : numm2[1];

        // 计算小数部分a2+b2
        int[] sum = new int[Math.max(a2.length(), b2.length()) + 1];
        int i = 0, j = 0, k = 1;
        while (i < a2.length() && j < b2.length()) {
            sum[k] = Add(a2.charAt(i), b2.charAt(j));
            i++;
            j++;
            k++;
        }
        while (i < a2.length()) {
            sum[k] = Add(a2.charAt(i), '0');
            k++;
            i++;
        }
        while (j < b2.length()) {
            sum[k] = Add('0', b2.charAt(j));
            k++;
            j++;
        }
        k = sum.length - 1;
        while (k > 0) {
            if (sum[k] >= 10) {
                int in = sum[k] / 10;
                sum[k] = sum[k] % 10;
                sum[k - 1] += in;
            }
            k--;
        }

        // 计算整数部分a1+b1
        int[] big = new int[Math.max(a1.length(), b1.length())+1];

        i = a1.length() - 1;
        j = b1.length() - 1;
        k = big.length - 1;
        while (i >= 0 && j >= 0) {
            big[k] = Add(a1.charAt(i),b1.charAt(j));
            k--;
            i--;
            j--;
        }
        while(i>=0){
            big[k] = Add(a1.charAt(i),'0');
            k--;
            i--;
        }
        while(j>=0){
            big[k] = Add('0',b1.charAt(j));
            k--;
            j--;
        }
        big[big.length-1] += sum[0];

        k = big.length-1;
        while (k > 0) {
            if (big[k] >= 10) {
                int in = big[k] / 10;
                big[k] = big[k] % 10;
                big[k - 1] += in;
            }
            k--;
        }

        // 合并
        StringBuilder str = new StringBuilder();
        for (int i1 = 0; i1 < big.length; i1++) {
            if(i1==0&&big[i1]==0)
                continue;
            str.append(big[i1]);
        }

        String result = str.toString();
        boolean flag = false;
//        if (sum.length == 2&&sum[1]==0){
//            System.out.println(str.toString());
//            return;
//        }

        str.append(".");
        for (int i1 = 1; i1 < sum.length; i1++) {
            str.append(sum[i1]);
            if(sum[i1]!=0)
                flag = true;
        }
        // 合并
        if (flag)
            System.out.println(str.toString());
        else
            System.out.println(result);
    }

    private static int Add(char a, char b) {
        if (a == '!' && b == '!')
            return 0;
        if ((a == '!' && b == '@') || (b == '!' && a == '@'))
            return 13;
        if ((a == '!' && b == '#') || (b == '!' && a == '#'))
            return 4;
        if (a == '@' && b == '@')
            return 7;
        if ((a == '@' && b == '#') || (b == '@' && a == '#'))
            return 20;
        if (a == '#' && b == '#')
            return 5;
        return (a - '0') + (b - '0');
    }

}
