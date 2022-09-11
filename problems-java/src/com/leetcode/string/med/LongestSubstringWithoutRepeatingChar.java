package com.leetcode.string.med;

import java.util.HashSet;
import java.util.Set;

/**
 * MEDIUM
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChar {

    /**

     Sliding window
     Two pointers, left and right. Set for each char seen.
     Increase right until you see a dupe. Then shift left by one and remove that char from set. Update max

     **/

    public int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<>();
        char[] arr = s.toCharArray();
        int left = 0, right = 0, max = 0;
        while (left < arr.length && right < arr.length) {
            if (seen.contains(arr[right])) {
                seen.remove(arr[left]);
                left++;
            } else {
                seen.add(arr[right]);
                right++;
                max = Math.max(max, right-left);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar sut = new LongestSubstringWithoutRepeatingChar();
        sut.lengthOfLongestSubstring("abcabcbb");
    }

}
