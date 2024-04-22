package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: false
 */
public class ContainsDuplicate {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If we find the same element at a different index, return true
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean containsDuplicateOptimal(int[] nums) {
        Set<Integer> numsHashSet = new HashSet<>();
        for (int num : nums) {
            // .add() returns false if the element was already present in the set,
            // so we can return true if it returns false
            if (!numsHashSet.add(num)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicateBruteForce(new int[]{1, 2, 3, 1}));
        System.out.println(cd.containsDuplicateOptimal(new int[]{1, 2, 3, 4}));
    }
}