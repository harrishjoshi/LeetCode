package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * Example:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKFrequent {

    public int[] topKFrequentBruteForce(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }

        // Create a map to store the frequent counts of the elements
        Map<Integer, Integer> frequentCounts = new HashMap<>();
        for (int num : nums) {
            // Update the frequent count of the element
            frequentCounts.put(num, frequentCounts.getOrDefault(num, 0) + 1);
        }

        // Initialize the result array with size k
        int[] result = new int[k];
        // Iterate over the frequent counts and find the top k frequent elements
        for (int i = 0; i < k; i++) {
            // Initialize the max count and key
            int maxCount = 0;
            int maxKey = 0;

            // Find the maximum frequent element
            for (Map.Entry<Integer, Integer> entry : frequentCounts.entrySet()) {
                // Update the max count and key
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxKey = entry.getKey();
                }
            }

            // Add the max element to the result
            result[i] = maxKey;
            // Remove the max element from the frequent counts
            frequentCounts.remove(maxKey);
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequent kFrequent = new TopKFrequent();
        int[] result = kFrequent.topKFrequentBruteForce(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        System.out.println(Arrays.toString(result));
    }
}
