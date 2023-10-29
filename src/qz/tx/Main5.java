package qz.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Num> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Num(sc.nextInt()));
        }
        System.out.println(method(list, k));

    }

    public static long method(List<Num> list, int k) {
        for (int i = 0; i < k; i++) {
            // 找个0最多的且有1的
            int max = 0;
            int index = -1;
            for (int j = 0; j < list.size(); j++) {
                Num num = list.get(j);
                if (num.index != -1 && num.zero > max) {
                    max = num.zero;
                    index = j;
                }
            }
            if (index == -1)
                break;//没有1了
            // 删除一个1
            Num num = list.get(index);
            num.deleteOne();
        }
        // 求和
        long ans = 0;
        for (Num num : list) {
            ans+=num.getVal();
        }
        return ans;

    }


    static class Num {
        int val;
        char[] bin;
        int zero = 0;//1后面儿0的个数
        int index = -1;//最后一个1的位置

        Num(int val) {
            this.val = val;
            bin = Integer.toBinaryString(val).toCharArray();
            for (int i = bin.length - 1; i >= 0; i--) {
                if (bin[i] == '0')
                    zero++;
                else if (bin[i] == '1') {
                    index = i;
                    return;
                }
            }
        }

        public void deleteOne() {
            bin[index] = '0';
            for (int i = index; i >= 0; i--) {
                if (bin[i] == '0')
                    zero++;
                else if (bin[i] == '1') {
                    index = i;
                    return;
                }
            }
            index = -1;
        }

        public int getVal() {
            int val = Integer.parseInt(String.valueOf(bin), 2);
            return val;
        }

    }
}
