package main.test.t2023;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class my1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            StringBuilder p = new StringBuilder();
            StringBuilder q = new StringBuilder();
            for (char c : a.toCharArray()) {
                int t = c - '0';
                if ((t & 1) == 1) {
                    p.append(t);
                } else {
                    q.append(t);
                }
            }
            BigDecimal x = new BigDecimal(p.toString().length() == 0 ? "0" : p.toString());
            BigDecimal y = new BigDecimal(q.toString().length() == 0 ? "0" : q.toString());
            BigDecimal res = x.subtract(y);
            System.out.println(res.abs());
        }
    }
}