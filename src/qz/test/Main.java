package qz.test;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int m = in.nextInt();
            int n = in.nextInt();
            boolean flg = false;//代表不是负数
            String table = "0123456789ABCDEF";
            //需要动态存储，所以使用单进程下效率更高的StringBuilder
            StringBuilder str = new StringBuilder();
            if(m < 0) {
                m = -m;
                flg = true;
            }

            while(m != 0) {
                str.append(table.charAt(m%n));
                m = m/n;
            }
            if(flg) {
                str.append("-");
            }
            str.reverse();
            System.out.println(str);
        }


}
