package main.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Daily_subdomainvisitcount {
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String,Integer> map = new HashMap<>();
            List<String> ans = new ArrayList<>();
            for(String t : cpdomains){
                String a[] = t.split(" ");
                int num = Integer.parseInt(a[0]);
                String yu= a[1];

                map.put(yu,num);
                for(int i=0;i<yu.length();i++){
                    if(yu.charAt(i)=='.'){
                        String substring = yu.substring(i+1, yu.length() - 1);
                        int x = map.getOrDefault(substring,0);
                        map.put(substring,num+x);
                    }
                }
            }
            for (String s : map.keySet()){
                String s1 = map.get(s) + " " + s;
                ans.add(s1);
            }
            return ans;

        }
    }
}
