package main.hard;

import java.util.LinkedList;
import java.util.List;

public class Test_regularexpressionmatching {
    public boolean isMatch(String s, String p) {
        LinkedList<Character> que = new LinkedList<>();
        for (char c : s.toCharArray()) {
            que.addLast(c);
        }
        LinkedList<char[]> tmp = new LinkedList<>();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*')
                tmp.addLast(new char[]{p.charAt(i), 'f'});
            else {
                tmp.getLast()[1] = 't';
            }
        }
        for (char[] chars : tmp) {
            if (que.size() == 0)
                break;
            if (chars[1] == 'f') {
                if (chars[0] == '.' || chars[0] == que.getFirst())
                    que.removeFirst();
                else
                    return false;
            } else {
                while (que.size() > 0 && (que.getFirst() == chars[0] || chars[0] == '.'))
                    que.removeFirst();
            }
            chars[1] = 'u';
        }
        if (que.size() == 0 && tmp.getLast()[1] == 'u')
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Test_regularexpressionmatching().isMatch("aab", "c*a*b"));
    }
}
