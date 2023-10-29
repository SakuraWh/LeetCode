package main.test.t2023.txcloud;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.calculate("(1+1-20)-2+(17+3)"));
        //System.out.println(main.calculate("-2+20"));
    }

    public int calculate(String s) {
        // write code here
        Stack<Character> operitor = new Stack<>();
        Stack<Integer> num = new Stack<>();
        num.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int t = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    t = t * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                num.push(t);
            } else if (c == '+' || c == '-') {
                while (!operitor.isEmpty() && (operitor.peek() == '+' || operitor.peek() == '-')) {
                    func(operitor, num);
                }
                operitor.push(c);
            } else if (c == '(')
                operitor.push(c);
            else if (c == ')') {
                while (operitor.peek() != '(') {
                    func(operitor, num);
                }
                operitor.pop();
            }


        }
        while (!operitor.isEmpty()) {
            func(operitor, num);
        }
        return num.pop();


    }

    public void func(Stack<Character> ops, Stack<Integer> num) {
        Character op = ops.pop();
        int b = num.pop();
        int a = num.pop();
        if (op == '+')
            num.push(a + b);
        else
            num.push(a - b);
    }
}
