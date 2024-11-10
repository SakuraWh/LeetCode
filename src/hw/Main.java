package hw;


/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2021. All rights reserved.
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * OJ考题代码：单板告警统计
 *
 * @author 命题组
 * @since 2021-01-30
 */

public class Main {
    // 待实现函数，在此函数中填入答题代码
    private static String[] getAllFault(String[] arrayA, String[] arrayB) {
        Set<String> set = new HashSet<>();
        for (String s : arrayA) {
            set.add(s);
        }
        for (String s : arrayB) {
            set.add(s);
        }
        String[] res = new String[set.size()];
        res = set.stream()
                .sorted()
                .collect(Collectors.toList())
                .toArray(res);
        String[] array = new String[res.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = res[res.length-i-1];
        }
        return array;
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int arrayALen = Integer.parseInt(cin.nextLine().trim());
        String[] arrayA = new String[0];
        if (arrayALen > 0) {
            arrayA = cin.nextLine().trim().split(" ");
        } else {
            cin.nextLine();
        }


        int arrayBLen = Integer.parseInt(cin.nextLine().trim());
        String[] arrayB = new String[0];
        if (arrayBLen > 0) {
            arrayB = cin.nextLine().trim().split(" ");
        }

        cin.close();

        String[] result = getAllFault(arrayA, arrayB);
        System.out.print("[" + String.join(" ", result) + "]");
    }
}
