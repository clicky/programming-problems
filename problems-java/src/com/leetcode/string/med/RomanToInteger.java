package com.leetcode.string.med;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /**

     Keep map of digits to int value
     Sum = 0
     Iterate left to right adding to sum
     Trick: subtraction is when previous digit is less than current

     **/

    public int romanToInt(String s) {

        int sum = 0, n = s.length();

        for (int i=0; i<n-1; i++) {
            int d1 = translate(s.charAt(i));
            int d2 = translate(s.charAt(i+1));
            if (d1<d2) sum-=d1;
            else sum+=d1;
        }
        sum += translate(s.charAt(n-1));

        return sum;

    }

    int translate(char c) {

        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else if (c == 'M') return 1000;
        else return 0;

    }

    public static void main(String[] args) {
        RomanToInteger sut = new RomanToInteger();
        sut.romanToInt("III");
    }

}
