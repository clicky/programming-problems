package com.leetcode.array.med;

public class FirstLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};

        int i = binarySearch(nums, target, 0, nums.length - 1);
        int left = i, right = i;
        while (nums[left] == target || nums[right] == target) {
            if (left >= 0 && nums[left] == target) left--;
            if (right < nums.length && nums[right] == target) right++;
        }
        res[0] = ++left;
        res[1] = --right;

        return res;

    }

    int binarySearch(int[] nums, int target, int left, int right) {

        if (left >= right) {
            return -1;
        }

        int mid = left + (int) (0.5 * (right - left));
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid+1, right);
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid);
        } else {
            return mid;
        }

    }

    public static void main(String[] args) {

        FirstLastPositionInSortedArray sut = new FirstLastPositionInSortedArray();
        sut.searchRange(new int[] { 5,7,7,8,8,10 }, 6);

    }

}
