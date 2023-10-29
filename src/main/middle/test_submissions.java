package main.middle;

import java.util.LinkedList;

public class test_submissions {
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("aaaaaaaa", "aaaaaaaaa"));
    }
    public static boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length())>=2)
            return false;
        LinkedList<Character> a = new LinkedList<>();
        LinkedList<Character> b = new LinkedList<>();
        for (char c : s.toCharArray())
            a.add(c);
        for (char c : t.toCharArray())
            b.add(c);
        while(!a.isEmpty()&&!b.isEmpty()){
            if(a.getFirst() == b.getFirst()){
                a.removeFirst();
                b.removeFirst();
            }
        }
        while(!a.isEmpty()&&!b.isEmpty()){
            if(a.getLast() == b.getLast()){
                a.removeLast();
                b.removeLast();
            }
        }
        if(Math.abs(a.size() - b.size())!=1)
            return false;
        return true;
    }
}
