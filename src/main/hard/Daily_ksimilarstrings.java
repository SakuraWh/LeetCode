package main.hard;

import javax.sound.midi.Soundbank;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Daily_ksimilarstrings {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kSimilarity("abccaacceecdeea",
                "bcaacceeccdeaae"));
    }
    static class Solution {
        public int kSimilarity(String s1, String s2) {
            //bfs算法
            Queue<String> queue = new LinkedList<>();
            Set<String> set = new HashSet<>();//当前已经在队列的不需要在加入队列中了

            queue.add(s1);
            int deep = 0;
            set.add(s1);
            while (true){
                for (int i = queue.size()-1; i >=0; i--) {
                    String temp = queue.poll();
                    int j=0;
                    for (;j<s2.length()&&temp.charAt(j)==s2.charAt(j);j++);
                    if (j==s2.length()){
                        return deep;
                    }
                    //目前s1j和s2j不同，从这里开始找
                    for (int k = j; k<s1.length(); k++){
                        if(temp.charAt(k)==s2.charAt(j)){
                            String swap = swap(j, k, temp);
                            if(!set.contains(swap)){
                                queue.add(swap);
                                set.add(swap);
                            }
                        }

                    }
                    //交换s1 k,j 位置
                }
                deep++;



            }

        }
        public String swap(int i,int j,String s){
            char[] chars = s.toCharArray();
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            return new String(chars);
        }
    }
}
