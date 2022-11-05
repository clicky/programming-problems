package com.leetcode.array.easy;

/**
 * EASY
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To
 * accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * https://leetcode.com/problems/merge-sorted-array
 */

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int tail = nums1.length-1;

        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[tail] = nums1[m-1];
                m--;
            } else {
                nums1[tail] = nums2[n-1];
                n--;
            }
            tail--;
        }

        while (n > 0) {
            nums1[tail] = nums2[n-1];
            n--;
            tail--;
        }

    }

}
