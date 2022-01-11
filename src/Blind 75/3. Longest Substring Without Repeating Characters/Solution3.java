import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Given a string s, find the length of the longest substring without repeating characters.

public class Solution3 {

    //hashmap; index calc for longest
    public static int lengthOfLongestSubstring1(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> hash = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (hash.containsKey(c)) {
                    max = Math.max(max, j-i+1);
                    break;
                }
                if (j == s.length() - 1) max = Math.max(max, j-i+1);
                hash.put(s.charAt(j), j);
            }
        }
        return max;
    }

    //hashset; set size for longest
    public static int lengthOfLongestSubstring2(String s) {
        int max = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aau";
        System.out.println(lengthOfLongestSubstring1(s));
    }
}
