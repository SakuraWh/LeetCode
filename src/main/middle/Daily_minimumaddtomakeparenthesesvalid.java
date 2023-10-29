package main.middle;

import java.util.Stack;

public class Daily_minimumaddtomakeparenthesesvalid {

    class Solution {
        public int minAddToMakeValid(String s) {
            /**
             * 依次入栈：
             *  （ 入栈
             *   ） 栈顶匹配，配不上就++
             */
            //Stack<Character> stack = new Stack<>();
            int stk = 0;
            int ans =0;
            for(char c : s.toCharArray()){
                if(c == '(')
                    stk++;
                else {
                    if(stk>0)
                        stk--;
                    else
                        ans++;

                }
            }
            return ans +stk;
        }
    }
}
