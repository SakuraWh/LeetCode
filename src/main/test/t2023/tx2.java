package main.test.t2023;

import java.util.*;

public class tx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> in = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            in.add(sc.next());
        }
        List<List<Character>> use = new ArrayList<>();
        for (String s : in) {
            Set<Character> set = new HashSet<>();
            List<Character> l = new ArrayList<>();
            for (char c : s.toCharArray()) {
                if (set.contains(c))
                    continue;
                l.add(c);
                set.add(c);
            }
            use.add(l);
        }
        dfs(0,use,new HashSet<Character>());
        System.out.println(ans);


    }
    static int ans =0;
    public static void dfs(int begin,List<List<Character>> use,Set<Character> set){
        if (begin == use.size()){
            ans ++;
            return;
        }
        List<Character> t = use.get(begin);
        for (int i = 0; i < t.size(); i++) {
            if(set.contains(t.get(i)))
                continue;
            set.add(t.get(i));
            dfs(begin+1,use,set);
            set.remove(t.get(i));
        }
    }
}
