package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {

    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public int[] twoSumOptimal(int[] nums, int target) {
        HashMap<Integer, Integer> complementIndicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementIndicesMap.containsKey(complement)) {
                return new int[]{complementIndicesMap.get(complement), i};
            }

            complementIndicesMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSumBruteForce(nums, 9)));
        System.out.println(Arrays.toString(twoSum.twoSumOptimal(nums, 13)));
    }
}