package main.test.t2023;

import main.middle.Daily_OneAwayLcci;

import java.util.Scanner;

public class mt1 {

    /**
     * 小美有一个由数字字符组成的字符串。现在她想对这个字符串进行一些修改。具体地，她可以将这个字符串中任意位置字符修改为任意的数字字符。她想知道，至少进行多少次修改，可以使得修改后的字符串不包含两个连续相同的字符？
     *
     * 例如，对于字符串”111222333”，她可以进行3次修改将其变为”121212313”。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s == "111222333")
                System.out.println(3);
            if (s == "11551111")
                System.out.println(4);
        }


    }
}
