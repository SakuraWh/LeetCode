package hw;


/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.*;


/**
 * OJ考题代码：公共字符
 *
 * @author 命题组
 * @since 2021-02-04
 */

public class Main8 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int nValue = cin.nextInt();
        int mValue = cin.nextInt();
        cin.nextLine();
        String[] strings = new String[mValue];
        for (int i = 0; i < mValue; i++) {
            strings[i] = cin.nextLine();
        }
        cin.close();

        char[] results = getNTimesCharacter(nValue, strings);

        System.out.print("[");
        for (int i = 0; i < results.length; i++) {
            if (i == 0) {
                System.out.print(results[i]);
            } else {
                System.out.print(" " + results[i]);
            }
        }
        System.out.print("]");
    }

    // 待实现函数，在此函数中填入答题代码
    private static char[] getNTimesCharacter(int nValue, String[] strings) {
        Set<Character> v = new HashSet<>();
        Set<Character> set = new HashSet<>();
        for (String s : strings) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                v.add(c);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            for (Character c : map.keySet()) {
                if(map.get(c)<nValue)
                    set.add(c);
            }
        }
        List<Character> list = new ArrayList<>();
        for (Character c : v) {
            if (!set.contains(c))
                list.add(c);
        }
        list.sort((a, b) -> a - b);
        char[] c = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            c[i] = list.get(i);
        }
        return c;
    }
}
