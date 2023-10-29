package qz.xc;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

            String a = sc.next();
            String b = sc.next();
            System.out.println(method(a, b) ? "Yes" : "No");
        }

    }

    public static boolean method(String a, String b) {
        if (a.length() != b.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            if (x != y) {
                if (map.containsKey(x) && map.get(x) != y) {
                        return false;
                }
                map.put(x, y);
            }

        }
        return true;
    }
}
