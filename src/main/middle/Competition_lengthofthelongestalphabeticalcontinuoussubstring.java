package main.middle;

public class Competition_lengthofthelongestalphabeticalcontinuoussubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestContinuousSubstring("abacaba");
    }
    static class Solution {
        public int longestContinuousSubstring(String s) {
            int i=0,j=1;
            int len=0,maxlen=0;
            for(;j<s.length();j++){
                if(s.charAt(j)==s.charAt(j-1)+1){
                    len++;
                }else{
                    maxlen=Math.max(maxlen,len);
                    len=0;
                    i=j;
                }
            }
            maxlen=Math.max(maxlen,len);

            return maxlen;
        }
    }
}
