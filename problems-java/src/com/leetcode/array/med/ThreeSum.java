package com.leetcode.array.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MEDIUM
 *
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (nums[left] == nums[left-1] && left < right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ThreeSum sut = new ThreeSum();
        sut.threeSum(new int[] { -1,0,1,2,-1,-4 });

    }

}