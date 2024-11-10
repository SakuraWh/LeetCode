package hw;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String commands = cin.nextLine();
        cin.close();
        String result = execCommand(commands);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static String execCommand(String commands) {
        int[] x = new int[]{0, 1, 0, -1};
        int[] y = new int[]{1, 0, -1, 0};
        int to = 0;
        int a = 0, b = 0;
        for (char c : commands.toCharArray()) {
            if (c == 'G') {
                a += x[to];
                b += y[to];
            } else if (c == 'L') {
                to=(to-1+4)%4;
            } else if (c == 'R') {
                to=(to+1+4)%4;
            }
        }
        return "("+a+","+b+")";
    }

}
