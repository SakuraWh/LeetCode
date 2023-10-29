package main.test.t2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class zhaoshang1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个正整数：");
        int number = scanner.nextInt();
        List<Integer> factors = getFactors(number);
        System.out.println(number + " 的所有因数为：" + factors.toString());
    }

    /**
     * 获取指定正整数的所有因数
     *
     * @param number 正整数
     * @return 所有因数
     */
    private static List<Integer> getFactors(int number) {
        HashMap<Integer, Integer> hap = new HashMap<>();
        int kNum = number;
        for (int i = 2; i <= kNum; ) {
            if (kNum % i == 0) {
                if (hap.keySet().contains(i)) {
                    hap.put(i, hap.get(i) + 1);
                } else {
                    hap.put(i, 1);
                }
                kNum = kNum / i;
                i=2;
            } else {
                i++;
            }
        }


        return null;


    }
}

