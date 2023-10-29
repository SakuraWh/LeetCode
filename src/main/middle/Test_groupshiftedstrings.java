package main.middle;

import java.util.*;

public class Test_groupshiftedstrings {
    public static void main(String[] args) {
        String[] a = new String[]{"fpbnsbrkbcyzdmmmoisaa","cpjtwqcdwbldwwrryuclcngw","a","fnuqwejouqzrif","js","qcpr","zghmdiaqmfelr","iedda","l","dgwlvcyubde","lpt","qzq","zkddvitlk","xbogegswmad","mkndeyrh","llofdjckor","lebzshcb","firomjjlidqpsdeqyn","dclpiqbypjpfafukqmjnjg","lbpabjpcmkyivbtgdwhzlxa","wmalmuanxvjtgmerohskwil","yxgkdlwtkekavapflheieb","oraxvssurmzybmnzhw","ohecvkfe","kknecibjnq","wuxnoibr","gkxpnpbfvjm","lwpphufxw","sbs","txb","ilbqahdzgij","i","zvuur","yfglchzpledkq","eqdf","nw","aiplrzejplumda","d","huoybvhibgqibbwwdzhqhslb","rbnzendwnoklpyyyauemm"};
        new Test_groupshiftedstrings().groupStrings(a);
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<Integer, List<Con>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (Integer integer : set) {
            
        }
        for (String s : strings) {
            List<Con> list = map.getOrDefault(s.length(), new ArrayList<>());
            if(s.equals("qzq")||s.equals("sbs"))
                System.out.println(1);
            if(list.isEmpty()){
                Con con = new Con(s.length());
                con.add(s);
                list.add(con);
            }else{
                boolean find = false;
                for (Con con : list) {
                    if(con.isLegcy(s)){
                        con.add(s);
                        find = true;
                        break;
                    }
                }
                if(find == false){
                    Con con1 = new Con(s.length());
                    con1.add(s);
                    list.add(con1);
                }
            }
            map.put(s.length(),list);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Con>> entry : map.entrySet()) {
            for (Con con : entry.getValue()) {
                result.add(con.step);
            }
        }
        return result;
    }

    private class Con {
        int len;
        List<String> step;

        Con(int len) {
            this.len = len;
            step = new ArrayList<>();
        }
        public boolean isLegcy(String c){
            if(c.length() == 1)
                return true;
            if(step.size() == 0)
                return true;
            String s = step.get(0);
            char a = s.charAt(0);
            char b = c.charAt(0);
            int st = (b-a +26)%26;
            for(int i=1;i<s.length();i++){
                int m = (c.charAt(i) - s.charAt(i) +26)%26;
                if(m!= st)
                    return false;
            }
            return true;
        }

        public void add(String c) {
            step.add(c);
        }
    }
}
