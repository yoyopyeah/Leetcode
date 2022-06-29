import java.util.ArrayList;
import java.util.List;

// package Blind 75.76. Minimum Window Substring;

/*
https://leetcode.com/problems/minimum-window-substring/
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.
*/

public class Solution {
    public String minWindow1(String s, String t) {
        int l = 0, r = 0; // two pointers
        List<Character> log = new ArrayList<Character>();
        char[] sArr = s.toCharArray();
        // simply an array also work 

        /*
        two pointers l and r.
        r moves right until substring(l, r) covers all letters in t
            all covered: log.size() = t.length;
        keep track of those two pointers
        move l right until a letter is eliminated, then move r until the letter is added back
        compare current l and r with previous, only update if the interval is smaller
        continue the above processes until r reaches the end.
        */


        return null;
    }

    public String minWindow2(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
          map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
          final char c1 = s.charAt(end);
          if (map[c1] > 0) counter--;
          map[c1]--;
          end++;
          while (counter == 0) {
            if (minLen > end - start) {
              minLen = end - start;
              minStart = start;
            }
            final char c2 = s.charAt(start);
            map[c2]++;
            if (map[c2] > 0) counter++;
            start++;
          }
        }
    
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
      }
}
