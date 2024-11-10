package hw;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * OJ考题代码：呼叫前传
 *
 * @author 命题组
 * @since 2020-03-20
 */
public class Main5 {
    // 待实现函数，在此函数中填入答题代码
    private static String calling(String status, List<RegCallOperate> regCallForwardNums) {
        if (status.equals("idle"))
            return "success";
        Map<Integer, String> map = new HashMap<>();
        for (RegCallOperate regCallForwardNum : regCallForwardNums) {
            map.put(regCallForwardNum.type, regCallForwardNum.number);
        }
        if (map.containsKey(0))
            return map.get(0);
        String res = "failure";
        switch (status) {
            case "busy":
                if (map.containsKey(1))
                    return map.get(1);
                break;
            case "no-response":
                if (map.containsKey(2))
                    return map.get(2);
                break;
            case "unreachable":
                if (map.containsKey(3))
                    return map.get(3);
                break;
        }
        return map.containsKey(4) ? map.get(4) : "failure";
    }

    static class RegCallOperate {
        int type = -1;
        String number = null;

        RegCallOperate(int type, String number) {
            this.type = type;
            this.number = number;
        }
    }

    // main入口由OJ平台调用
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String[] first = cin.nextLine().split(" ");
        int row = Integer.parseInt(first[0]);
        String status = first[1];
        List<RegCallOperate> regCallForwardNums = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            String[] operate = cin.nextLine().split(" ");
            RegCallOperate regCallOperate = new RegCallOperate(Integer.parseInt(operate[0]), operate[1]);
            regCallForwardNums.add(regCallOperate);
        }
        cin.close();

        String result = calling(status, regCallForwardNums);
        System.out.println(result);
    }
}
