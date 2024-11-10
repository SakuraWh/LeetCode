package hw;


/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * OJ考题代码：促销活动
 *
 * @author 命题组
 * @since 2021-01-30
 */

public class Main12 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int row = cin.nextInt();
        cin.nextLine();
        String[] orderTime = new String[row];
        for (int i = 0; i < row; i++) {
            orderTime[i] = cin.nextLine();
        }
        cin.close();
        int result = freeOrder(orderTime);
        System.out.print(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static int freeOrder(String[] orderTime) {
        toSec("2019-01-01 00:00:00.001");
        Map<String, List<Integer>> map = new HashMap<>();
        for (String s : orderTime) {
            String[] a = s.split("\\.");
            List<Integer> list = map.getOrDefault(a[0], new ArrayList<>());
            list.add(Integer.parseInt(a[1]));
            map.put(a[0], list);
        }
        int res = 0;
        for (String s : map.keySet()) {
            map.get(s).sort((a, b) -> a - b);
            int min = 1;
            for (int i = 1; i < map.get(s).size(); i++) {
                if (map.get(s).get(i) == map.get(s).get(0))
                    min++;
                else
                    break;
            }
            res += min;
        }
        return res;
    }

    private static long toSec(String time) {
        // 2019-01-01 00:00:00.001
//        int year = Integer.parseInt(time.substring(0, 4));
//        int mouth = Integer.parseInt(time.substring(5, 7));
//        int day = Integer.parseInt(time.substring(8, 10));
//        int hour = Integer.parseInt(time.substring(11, 13));
//        int min = Integer.parseInt(time.substring(14, 16));
//        int sec = Integer.parseInt(time.substring(17, 19));
//        long res = year*
        return 0;
    }

}
