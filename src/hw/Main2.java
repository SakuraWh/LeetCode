package hw;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ考题代码：大小端整数
 *
 * @author 命题组
 * @since 2021-02-10
 */

public class Main2 {
    // 待实现函数，在此函数中填入答题代码
    private static String getHexString(String num) {
        long l = 0;
        try {
            l = Long.parseLong(num);
        }catch (Exception e){
            return "overflow";
        }

        if (l < -Math.pow(2, 31) || l >= Math.pow(2, 32))
            return "overflow";
        String hexString = Long.toHexString(l);
        hexString = String.format("%8s", hexString).replace(' ', '0');
        StringBuilder sb = new StringBuilder();
        for (int i = hexString.length(); i > 0; i -= 2) {
            sb.append(hexString.substring(i - 2, i));
        }
        String littleEndianString = sb.toString();

        return addSpace(hexString.toUpperCase()) + "\n" + addSpace(littleEndianString.toUpperCase());
    }

    private static String addSpace(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); ) {
            sb.append(num.charAt(i));
            i++;
            if (i % 2 == 0)
                sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String num = cin.nextLine();
        cin.close();
        String result = getHexString(num);
        System.out.println(result);
    }
}
