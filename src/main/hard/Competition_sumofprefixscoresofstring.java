package main.hard;

import java.util.HashMap;
import java.util.Map;

public class Competition_sumofprefixscoresofstring{
    public static void main(String[] args) {
        new Solution().sumPrefixScores(new String[]{"abc","ab","bc","b"});
    }
    static class Solution {
        public int[] sumPrefixScores(String[] words) {
            trieNode root = new trieNode();
            for (String s  :words){
                root = createTrie(root,s);
            }

            int[] ans =new int[words.length];
            for (int i = 0; i < words.length; i++) {
                ans[i] = getNums(root,words[i]);
            }
            return ans;



        }
        public int getNums(trieNode root,String s){
            trieNode t = root;
            int ans =0;
            for (char c : s.toCharArray()){
                if(t.next[c-'a']!=null){
                    ans+=t.next[c-'a'].val;
                }
                t=t.next[c-'a'];
            }
            return ans;
        }
        public trieNode createTrie(trieNode root,String s){
            trieNode t =root;
            for(char c : s.toCharArray()){
                if (t.next[c-'a']!=null){

                }else{
                    t.next[c-'a'] = new trieNode(c);
                }
                t=t.next[c-'a'];
                t.val++;
            }
            return root;
        }
        public class trieNode{
            char data;
            trieNode[] next;
            int val;

            trieNode(){
                data = 0;
                val=0;
                next = new trieNode[26];
            }
            trieNode(char c){
                data = c;
                val =0;
                next = new trieNode[26];
            }
        }

//        public int[] sumPrefixScores(String[] words) {
//            Map<String,Integer> map = new HashMap<>();
//            for(String s : words){
//                for (int i = 1; i <= s.length(); i++) {
//                    String substring = s.substring(0, i);
//                    map.put(substring,map.getOrDefault(substring,0)+1);
//                }
//            }
//
//            int[] ans = new int[words.length];
//            for (int i = 0; i < words.length; i++) {
//                int t =0;
//                for (int j = 1; j <= words[i].length(); j++) {
//                    String substring = words[i].substring(0, j);
//                    t+= map.getOrDefault(substring,0);
//                }
//                ans[i] =t;
//            }
//            return ans;
//        }
    }
}
