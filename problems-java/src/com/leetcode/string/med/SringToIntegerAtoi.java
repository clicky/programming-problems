package com.leetcode.string.med;

/**
 * MEDIUM
 *
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s
 * atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is
 * either. This determines if the final result is negative or positive respectively. Assume the result is positive if
 * neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the
 * string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is
 * 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains
 * in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1
 * should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class SringToIntegerAtoi {

    /**

     1. Iterate through any whitespace chars

     2. Check for sign

     3. Iterate through digits only

     4. Check for overflow

     5. Build total

     6. Apply sign and return

     **/

    public int myAtoi(String str) {

        int sign = 1, i = 0, res = 0;

        if (str == null || str.isEmpty()) return 0;

        int len = str.length();

        // Whitespace
        while (i < len && str.charAt(i) == ' ') i++;

        // Sign
        if (i >= len) {
            return res;
        }

        char c = str.charAt(i);
        if (c == '-' || c == '+') {
            sign = (c == '-') ? -1 : 1;
            i++;
        }

        // Digits
        while (i < str.length()) {

            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) break;

            // Have not updated rest yet so check for MAX/10 to see if update will overflow
            // OR keep as a long, update, then check for int overflow and cap
            if (res > Integer.MAX_VALUE/10 || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            res = res * 10 + digit;
            i++;

        }

        return res * sign;

    }

}
