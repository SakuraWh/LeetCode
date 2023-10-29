package main.test.t2023.txcloud;

import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Main1 main = new Main1();
        //System.out.println(main.calculate("(1+1-20)-2+(17+3)"));
        System.out.println(main.calculate("-2+20"));
    }
    public int calculate(String s) {
        // write code here
        Stack<Character> operitor = new Stack<>();
        Stack<Integer> num = new Stack<>();
        num.push(0);

        int i = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    operitor.push(c);
                    break;
                case ')':
                    while(true){
                        if (flag) {
                            num.push(i);
                            i = 0;
                            flag = false;
                        }
                        Character op = operitor.pop();
                        if(op=='(')
                            break;
                        //执行一次运算过程
                        //func
                        func(op,num);
                    }
                    break;
                case '+':
                    if (flag) {
                        num.push(i);
                        i = 0;
                        flag = false;
                    }
                    operitor.push(c);
                    break;
                case '-':
                    if (flag) {
                        num.push(i);
                        i = 0;flag = false;
                    }
                    operitor.push(c);
                    break;
                default:
                    flag = true;
                    i=i*10+(c-'0');
            }
        }
        if (flag) {
            num.push(i);
            i = 0;
        }

        while(true){
            if(operitor.isEmpty())
                break;
            Character op = operitor.pop();
            func(op,num);
        }
        int x = num.pop();
        return x;


    }
    public void func(char op,Stack<Integer> num){
        int b = num.pop();
        int a = num.pop();
        if (op=='+')
            num.push(a+b);
        else
            num.push(a-b);
    }
}
