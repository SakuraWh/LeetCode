package hw;


/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * OJ考题代码：话单发送
 *
 * @author 命题组
 * @since 2020-04-21
 */

public class Main6 {
    // 待实现函数，在此函数中填入答题代码
    private static int getMaxSendNumber(int cap, int[] billLen, int[] billPrior) {
        List<PO> list = new ArrayList<PO>();
        for (int i = 0; i < billLen.length; i++) {
            list.add(new PO(billPrior[i], billLen[i]));
        }
        list.sort(new Comparator<PO>() {
            @Override
            public int compare(PO o1, PO o2) {
                if (o1.prior == o2.prior)
                    return o1.weight - o2.weight;
                return o1.prior - o2.prior;
            }
        });
        int k =0;
        int w = 0;
        for (PO po : list) {
            w+=po.weight;
            if(w<=cap)
                k++;
            else
                return k;
        }

        return k ;
    }

    static class PO {
        int prior;
        int weight;

        public PO(int prior, int weight) {
            this.prior = prior;
            this.weight = weight;
        }
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int cap = cin.nextInt();
        int line = cin.nextInt();
        int[] billLen = new int[line];
        for (int i = 0; i < line; i++) {
            billLen[i] = cin.nextInt();
        }
        int[] billPrior = new int[line];
        for (int i = 0; i < line; i++) {
            billPrior[i] = cin.nextInt();
        }
        cin.close();
        int result = getMaxSendNumber(cap, billLen, billPrior);
        System.out.println(result);
    }
}
