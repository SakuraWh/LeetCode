package qz.mt;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n < 7) {
            System.out.println("No");
            return;
        }
        String meituan = "meituan";
        in.nextLine();
        List<Set<Character>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Character> t = new HashSet<>();
            String s = in.nextLine();
            for (char c : s.toCharArray()) {
                t.add(c);
            }
            arr.add(t);
        }
        int f = 0;
        for (int i = 0; i < meituan.length();) {
            if(f == arr.size()){
                System.out.println("No");
                return;
            }
            char c = meituan.charAt(i);
            if(arr.get(f).contains(c)){
                i++;
            }
            f++;
        }
        System.out.println("Yes");
    }
}
