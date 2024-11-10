package hw;


/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * OJ考题代码：四则运算求值
 *
 * @author 命题组
 * @since 2021-02-04
 */

public class Main9 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine();
        cin.close();
        String result = calculate(expression);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static String calculate(String expression) {

        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;
        int n = expression.length();
        char sign = '+';

        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (sign == '+') {
                    nums.push(num);
                } else if (sign == '-') {
                    nums.push(-num);
                } else if (sign == '*') {
                    nums.push(nums.pop() * num);
                } else if (sign == '/') {
                    if(num==0)
                        return "error";
                    nums.push(nums.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        while (!nums.isEmpty()) {
            result += nums.pop();
        }

        return result+"";

    }
}
