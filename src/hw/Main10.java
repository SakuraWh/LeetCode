package hw;


/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 * OJ考题代码：字符排序
 *
 * @author 命题组
 * @since 2021-02-04
 */

public class Main10 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String inputStr = cin.nextLine();
        cin.close();
        String result = characterSort(inputStr);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static String characterSort(String inputStr) {
        List<Character> num = new ArrayList<>();
        List<Character> cha = new ArrayList<>();
        for (char c : inputStr.toCharArray()) {
            if (c <= '9' && c >= '0')
                num.add(c);
            else
                cha.add(c);

        }
        num.sort((a, b) -> a - b);
        cha.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (((o1 <= 'Z' && o1 >= 'A') && (o2 <= 'Z' && o2 >= 'A')) || ((o1 <= 'z' && o1 >= 'a') && (o2 <= 'z' && o2 >= 'a')))
                    return o1 - o2;
                if (o1 <= 'Z' && o1 >= 'A')
                    return 1;
                return -1;
            }
        });
        StringBuilder res = new StringBuilder();
        for (int i = 0, a = 0, b = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) <= '9' && inputStr.charAt(i) >= '0') {
                res.append(num.get(a++));
            } else {
                res.append(cha.get(b++));
            }
        }
        return res.toString();
    }
}
