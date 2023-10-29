package main.test.t2023.txcloud;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n  = sc.nextInt();
            List<Set<Character>> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String next = sc.next();
                Set<Character> set = new HashSet<>();
                for (char c : next.toCharArray()) {
                    set.add(c);
                }
                list.add(set);
            }
            int l = 0;
            int r = list.size() -1;
            while(l<r){
                Set<Character> left = list.get(l);
                Set<Character> right = list.get(r);
                boolean seem = hasSeem(left, right);
                if (!seem){
                    System.out.println("No");
                    break;
                }
                l++;
                r--;
            }
            if(l>=r){
                System.out.println("Yes");
            }
        }

    }
    public static boolean hasSeem(Set<Character> left,Set<Character> right){
        for (Character c : left) {
            if (right.contains(c))
                return true;
        }
        return false;
    }
}
