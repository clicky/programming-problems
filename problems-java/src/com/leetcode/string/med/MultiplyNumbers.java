package com.leetcode.string.med;

/**
 *
 * MEDIUM
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * https://leetcode.com/problems/multiply-strings
 *
 */

public class MultiplyNumbers {

    /**

     123
     x 456

     > 6e0*3 + 6e0*20 + 6e0*100 = 18 + 120 + 600      = 738
     > 5e1*3 + 5e1*20 + 5e1*100 = 150 + 1000 + 5000   = 6150
     > 4e2*3 + 4e2*20 + 4e2*100 = 1200 + 8000 + 40000 = 49200
     > 738 + 6150 + 49200 = 56088

     **/

    public String multiply(String num1, String num2) {

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        if ((arr1.length == 1 && arr1[0] == '0') || (arr2.length == 1 && arr2[0] == '0')) return new String("0");

        int[] res = new int[arr1.length + arr2.length];

        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2.length; j++) {
                int curr = ord(arr1[arr1.length-1-i]) * ord(arr2[arr2.length-1-j]);
                res[i+j] += curr;
                res[i+j+1] += res[i+j]/10;
                res[i+j] = res[i+j]%10;
            }
        }

        StringBuilder sb = new StringBuilder();

        // Skip trailing zeroes
        int i=res.length-1;
        while (res[i] == 0) i--;

        // Reverse list into SB
        for (; i>=0; i--) {
            sb.append(res[i]);
        }

        return sb.toString();

    }

    private int ord(char c) {
        return c-'0';
    }

}
