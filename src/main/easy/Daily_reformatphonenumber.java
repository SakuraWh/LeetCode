package main.easy;

import java.util.ArrayList;
import java.util.List;

public class Daily_reformatphonenumber {
    class Solution {
        public String reformatNumber(String number) {
            List<Character> ans = new ArrayList<>();
            char[] num = number.toCharArray();
            int k =0;
            for (int i = 0; i < number.length(); i++) {
                if (num[i] != '-' && num[i] != ' ') {
                    ans.add(num[i]);
                }
            }
            StringBuffer res = new StringBuffer();
            int t =0;
            if(ans.size()%3==1)
                t=4;
            if(ans.size()%3==0)
                t=3;
            if(ans.size()%3==2)
                t=2;
            for (int i = 0; i < ans.size()-t; i++) {
                res.append(ans.get(i));
                if((i+1)%3==0)
                    res.append('-');
            }
            for (int i = ans.size()-t; i < ans.size(); i++) {
                if(t==4&&i!=ans.size()-t&&((i-ans.size())%2==0))
                    res.append('-');
                res.append(ans.get(i));

            }


            return res.toString();
        }
    }
}
