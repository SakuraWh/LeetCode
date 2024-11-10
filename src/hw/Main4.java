package hw;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

/**
 * OJ考题代码：表达式计算
 *
 * @author 命题组
 * @since 2020-05-23
 */
public class Main4 {
    // 待实现函数，在此函数中填入答题代码
    private static int calcExpression(String expression) {
        String[] split = expression.split(",");
        Stack<Integer> stack = new Stack<>();
        for (String s : split) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int c = stack.pop();
                    int d = stack.pop();
                    stack.push(d / c);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();


    }

    // main入口由OJ平台调用
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine();
        cin.close();

        int result = calcExpression(expression);
        System.out.println(result);
    }
}
