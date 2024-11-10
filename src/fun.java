import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fun {
    public static void main(String[] args) {
        String input = "ababcbcd";
        List<String> result = findLongestSubstrings(input);
        System.out.println(result);
    }

    public static List<String> findLongestSubstrings(String input) {
        List<String> result = new ArrayList<>();
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0, j = 0; j < input.length(); j++) {
            char currentChar = input.charAt(j);
            if (charIndexMap.containsKey(currentChar)) {
                i = Math.max(i, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, j);
            int currentLength = j - i + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                result.clear();
                result.add(input.substring(i, j + 1));
            } else if (currentLength == maxLength) {
                result.add(input.substring(i, j + 1));
            }
        }
        return result;
    }
}
