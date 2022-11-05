package com.leetcode.array.med;

/**
 * MEDIUM
 *
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr:
 * [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical
 * order, then the next permutation of that array is the permutation that follows it in the sorted container. If such
 * arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending
 * order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger
 * rearrangement.
 *
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 * https://leetcode.com/problems/next-permutation/
 */

public class NextPermutation {

    /**

     Permutation made by making a decision at each index to place an element.
     This element cannot be placed again. To find the next permutation, backrack one decision from end
     and make a different decision.

     1 2 3
     Last decision was to place 2 @ i1 then i2 had no choice but to place 3.
     Backtracking here, we can place 3 @ i1 instead to get 1 3 2.

     To find the point at which need to make a different decision,
     we back track whilst we see a strickly decreasing sequence from the end.
     i.e. 6 2 1 5 4 3 0 has a SDS of 5 4 3 0, so make a different decision at i2.
     The decision should be the next greatest value in the SDS i.e. 3.
     Swap these values to give 6 2 3 5 4 1 0. Now after 3 there is still an SDS which means
     this is the last permutation after placing 3 @ i2. So we reverse the SDS to get the first permuation.

     6 2 1 5 4 3 0
     6 2 3 5 4 1 0
     6 2 3 0 1 4 5

     **/

    public void nextPermutation(int[] nums) {

        // Base
        if (nums == null || nums.length == 1) return;

        // 1. Find index where decision needs to change (find element before SDS)
        int i = nums.length-1;
        while (i >= 0) {
            if (i < nums.length-1 && nums[i] < nums[i+1]) break;
            i--;
        }

        // 2. Descending order special case i.e. original array is [3,2,1] so next permutation is [1,2,3]
        if (i == -1) {
            reverse(nums, 0);
            return;
        }

        // 3. Find next greatest value in SDS and swap
        int j = nums.length-1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);

        // 3. Reverse the SDS
        reverse(nums, i+1);

    }

    private void reverse(int[] nums, int i) {
        for (int j=i; j<i+((nums.length-i)/2); j++) {
            swap(nums, j, nums.length-(j-i+1));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
