package qz.xc;

import java.util.Scanner;
import java.util.Stack;

public class Main5 {
    public static void main(String[] args) {


    }
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            if(stack.isEmpty()){
                stack.push(num);
            }else{
                if(stack.peek() == num){
                    stack.push(num);
                }else
                    stack.pop();
            }
        }
        return  stack.pop();
    }
}
