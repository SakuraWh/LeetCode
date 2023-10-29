package main.easy;

import java.util.HashSet;
import java.util.Set;

public class Test_longestsubstringwithoutrepeatingcharacters {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 1;
        int max = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add(chars[0]);
        while (j < s.length()) {
            while (set.contains(chars[j])) {
                set.remove(chars[j]);
            }
            max = Math.max(max, j - i + 1);
            set.add(chars[j]);
        }
        return max;
    }
}
