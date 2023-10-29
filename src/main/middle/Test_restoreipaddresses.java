package main.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test_restoreipaddresses {
    public static void main(String[] args) {
        List<String> strings = new Solution().restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
    static class Solution {
        List<String> result = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        public List<String> restoreIpAddresses(String s) {
            dfs(0,s);
            return result;
        }

        public void dfs(int begin,String s){
            int n = s.length()-begin;
            if(n>((4- path.size())*3))
                return;
            if(path.size() == 4){
                if(begin!=s.length())
                    return;
                StringBuffer stringBuffer = new StringBuffer();
                LinkedList temp=new LinkedList<>(path);
                while(temp.size()>1){
                    stringBuffer.append(temp.removeFirst());
                    stringBuffer.append(".");
                }
                stringBuffer.append(temp.removeFirst());
                result.add(stringBuffer.toString());
                return;
            }
            for(int i = begin+1;i<=begin+3&&i<=s.length();i++){
                int t = check_get(s.substring(begin,i));
                if(t==-1)
                    return;
                path.add(t);
                dfs(i,s);
                path.removeLast();
            }
        }
        public int check_get(String s){
            if(s.length()>1 && s.charAt(0)=='0')
                return -1;
            int x = Integer.parseInt(s);
            if(x>255||x<0)
                return -1;
            return x;
        }
    }
}
