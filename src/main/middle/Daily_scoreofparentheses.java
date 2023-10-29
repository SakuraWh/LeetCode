package main.middle;

import java.util.Stack;

public class Daily_scoreofparentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfParentheses("(((())()))"));
    }
    static class Solution {
        public int scoreOfParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            // (-1   )-2
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(-1);
                } else if (c == ')') {
                    Integer pop = stack.pop();
                    int t = 0;
                    while (pop != -1) {
                        t += pop;
                        pop = stack.pop();
                    }
                    stack.push(t==0?1:t*2);
                }
            }
            int ans =0;
            while (!stack.isEmpty()){
                ans+=stack.pop();
            }
            return ans;
        }
    }
}
