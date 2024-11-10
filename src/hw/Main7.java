package hw;


/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * OJ考题代码：统计无重复字符的字符串
 *
 * @author 命题组
 * @since 2020-04-20
 */

public class Main7 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String input = cin.nextLine();
        cin.close();
        int result = getCountOfSubString(input);
        System.out.println(result);
    }


    private static int getCountOfSubString(String input) {
        int k = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                if(set.contains(input.charAt(j)))
                    break;
                k++;
                set.add(input.charAt(j));
            }
            set.clear();
        }
        return k;
    }

}
