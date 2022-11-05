package com.leetcode.string.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * HARD
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the empty
 * string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    /**

     1. Build freq map of the string being searched for.
     2. Two pointers for sliding window, scan sring being being searched building freq map, shifting only right pointer.
     3. Once freq map matchines (>= for each char in #1), calc size and store. Update size if necessary (find min window size).
     4. Once match found, shift left pointe until no longer a match. Then resume from #2.

     **/

    public String minWindow(String s, String t) {

        // 1. Freq map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            int count = freqMap.getOrDefault(c, 0);
            freqMap.put(c, count+1);
        }

        // 2. Two pointer sliding window scan
        int left = 0, right = 0, start = 0, minSize = Integer.MAX_VALUE, matches = 0, needed = freqMap.size();
        for (; right<s.length(); right++) {
            // Check char and add to map
            char c = s.charAt(right);
            if (freqMap.containsKey(c)) {
                int count = freqMap.get(c) - 1;
                freqMap.put(c, count);
                if (count == 0) {
                    matches++;
                }
            }
            // Update window and shift left
            while (matches == needed) {
                int size = right-left+1;
                if (size < minSize) {
                    minSize = size;
                    start = left;
                }

                char r = s.charAt(left++);
                if (freqMap.containsKey(r)) {
                    int count = freqMap.get(r);
                    if (count == 0) {
                        matches--;
                    }
                    freqMap.put(r, count+1);
                }
            }

        }

        return minSize > s.length() ? "" : s.substring(start, start+minSize);

    }

}
