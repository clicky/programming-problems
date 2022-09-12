package com.leetcode.array.easy;

/**
 *
 * EASY
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
 * element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be
 * placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k
 * elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra
 * memory.
 */
public class RemoveDupesFromSortedArray {

    /**

     Brute:
     Iterate over array with i
     For each i
     Iterate ahead with j until i != j
     If j-i > 1
     i+1=j
     return i

     One pass:
     boolean map of size 200
     keep tail poiner starting at 0
     iterate array
     if not seen: mark as seen and set val to tail and tail++

     One pass:
     Keep track of tail and current element
     Iterate from second element, coninue if same as current
     When see diff element, set arr[tail] to i and incremenet

     **/

    public int removeDuplicates(int[] nums) {

        //return onePassWithMap(nums);
        return optimal(nums);

    }

    int optimal(int[] nums) {

        int tail = 1, curr = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == curr) {
                continue;
            } else {
                nums[tail++] = nums[i];
                curr = nums[i];
            }
        }
        return tail;

    }

    int onePassWithMap(int[] nums) {

        boolean[] map = new boolean[201];
        int tail = 0;
        for (int i=0; i<nums.length; i++) {
            int index = nums[i]+100;
            if (!map[index]) {
                map[index] = true;
                nums[tail++] = nums[i];
            }
        }
        return tail;

    }

}
