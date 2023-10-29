package main.test.t2023;

import java.util.Scanner;

public class pdd1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.next();
            StringBuilder res = new StringBuilder();
            int t = 0;
            int b = 0;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    //数字
                    t = t * 10 + s.charAt(i) - '0';
                } else {
                    //字母
                    for (int j = 0; j < t; j++) {
                        res.append(s.charAt(i));
                    }
                    t=0;
                }
            }
            System.out.println(res.toString());
        }
    }
}
