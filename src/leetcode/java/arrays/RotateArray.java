package leetcode.java.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Input:  nums = [1, 2, 3, 4, 5, 6, 7], k = 3
 * Output: [5, 6, 7, 1, 2, 3, 4]
 * <p>
 * LeetCode problem: <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 */
public class RotateArray {


    public static void intermediateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            throw new IllegalArgumentException("Invalid Args");
        }

        if (k > nums.length) {
            k = k % nums.length;
        }

        int[] result = new int[nums.length];

        // Put the last k item in first place in reverse order
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        // Copy the remaining item from k positon
        for (int j = 0, i = k; i < nums.length; j++, i++) {
            result[i] = nums[j];
        }

        // Copy a result array in an original array
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        var items = new int[]{1, 2, 3, 4, 5, 6, 7};
        intermediateArray(items, 3);
        System.out.println(Arrays.toString(items));
    }
}
