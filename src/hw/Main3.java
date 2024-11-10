package hw;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：二进制转十进制
 *
 * @author 命题组
 * @since 2021-01-12
 */

public class Main3 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String binaryString = cin.nextLine();
        cin.close();
        int result = binaryToDecimal(binaryString);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static int binaryToDecimal(String binaryString) {
        return (int) Long.parseLong(binaryString, 2);

    }
}
