package main.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_lettercombinationsofaphonenumber {
    Map<Character,char[]> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        if(digits.length()==0)
            return ans;
//        ans.add("");
//        for (char c : digits.toCharArray()) {
//            char[] chars = map.get(c);
//            List<String> tmp = new ArrayList<>();
//            for (String an : ans) {
//                for (char aChar : chars) {
//                    tmp.add(an + aChar);
//                }
//            }
//            ans = tmp;
//        }
        dfs(digits.toCharArray(),0);
        return ans;
    }
    StringBuffer stringBuffer = new StringBuffer();
    public void dfs(char[] digits,int k){
        if(k==digits.length)
            ans.add(stringBuffer.toString());
        char[] chars = map.get(digits[k]);
        for (char aChar : chars) {
            stringBuffer.append(aChar);
            dfs(digits,k+1);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }
}
