package main.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 39;

        int k = 0;
        // 找到最后一位1，加或者减去后1得数量
        while (n != 0) {
            char[] array = Integer.toBinaryString(n).toCharArray();
            int i = array.length - 1;
            for (; i >= 0; i--) {
                if (array[i] == '1')
                    break;
            }
            // +-
            int a = n;
            int b = n;
            int t = (int) Math.pow(2, array.length - i);
            a = a - t;
            b = b + t;
            if (getOne(a) < getOne(b))
                n = a;
            else n = b;
            k++;
        }
        System.out.println(k);


    }

    public static int getOne(int number) {
        int count = 0;
        while (number > 0) {
            if (number % 2 == 1) {
                count++;
            }
            number /= 2;
        }
        return count;
    }
}
