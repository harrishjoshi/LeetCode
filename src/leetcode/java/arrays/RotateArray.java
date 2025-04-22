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

    /**
     * Rotates an array to the right by k positions using extra space.
     * This method creates a new temporary array to store the rotated values
     * before copying them back to the original array.
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) due to the temporary array
     */
    public static void solution1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            throw new IllegalArgumentException("Invalid Args");
        }

        if (k > nums.length) {
            k = k % nums.length;
        }

        int[] result = new int[nums.length];

        // Put the last k items in the first positions
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        // Copy the remaining items from the original array
        for (int j = 0, i = k; i < nums.length; j++, i++) {
            result[i] = nums[j];
        }

        // Copy the result array back into the original array
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    /**
     * Rotates an array to the right by k positions using in-place swapping.
     * This method performs k rotations, where each rotation shifts all elements
     * one position to the right by swapping adjacent elements.
     * Time Complexity: O(n*k) where n is the length of the array
     * Space Complexity: O(1) as it only uses a single temp variable
     */
    public static void solution2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            throw new IllegalArgumentException("Invalid Args");
        }

        if (k > nums.length) {
            k = k % nums.length;
        }

        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }

    /**
     * Rotates an array right by k positions using triple reverse approach
     * Time: O(n), Space: O(1)
     */
    public static void solution3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            throw new IllegalArgumentException("Invalid Args");
        }

        if (k > nums.length) {
            k = k % nums.length;
        }

        int firstPartLength = nums.length - k;

        // Reverse first n-k elements
        reverse(nums, 0, firstPartLength - 1);

        // Reverse last k elements
        reverse(nums, firstPartLength, nums.length - 1);

        // Reverse entire array
        reverse(nums, 0, nums.length - 1);
    }

    /**
     * Reverses elements between left and right indices (inclusive).
     */
    public static void reverse(int[] nums, int left, int right) {
        if (nums.length == 1 || left >= right) {
            return;
        }

        while (left < right) {
            // Swap elements
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        var items = new int[]{1, 2, 3, 4, 5, 6, 7};
//        solution1(items, 3);
//        solution2(items, 3);
        solution3(items, 3);
        System.out.println(Arrays.toString(items));
    }
}
