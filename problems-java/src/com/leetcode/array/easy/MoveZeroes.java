package com.leetcode.array.easy;

import java.util.Arrays;

/**
 * EASY
 *
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
 * elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {

    /**

     Move all non-zero elements to the start
     Keep track of tail starting from 0
     Iterate all elements, updating index tail with element if non 0 and then updating tail by 1
     Fill remainder (tail to end) with 0

     **/

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int tail = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[tail++] = nums[i];
            }
        }

        for (; tail<nums.length; tail++) {
            nums[tail] = 0;
        }

    }


}
