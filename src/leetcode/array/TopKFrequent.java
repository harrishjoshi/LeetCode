package leetcode.array;

import java.util.*;

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

    public int[] topKFrequentOptimal(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }

        Map<Integer, Integer> numberCounts = new HashMap<>();
        Map<Integer, List<Integer>> countFrequencies = new HashMap<>();

        // Count the frequency of each element
        for (int num : nums) {
            numberCounts.put(num, numberCounts.getOrDefault(num, 0) + 1);
        }

        // Store the elements with the same frequency in a list
        for (Map.Entry<Integer, Integer> entry : numberCounts.entrySet()) {
            if (!countFrequencies.containsKey(entry.getValue())) {
                countFrequencies.put(entry.getValue(), new ArrayList<>());
            }

            countFrequencies.get(entry.getValue()).add(entry.getKey());
        }

        // Initialize the result array with size k
        int[] result = new int[k];
        int resultIndex = 0;
        // Iterate over the frequencies in descending order
        for (int i = nums.length; i > 0; i--) {
            if (countFrequencies.containsKey(i)) {
                // Add the elements with the same frequency to the result
                for (int num : countFrequencies.get(i)) {
                    result[resultIndex++] = num;
                    // Return the result if the k elements are found
                    if (resultIndex == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequent kFrequent = new TopKFrequent();
        int[] bruteForceResult = kFrequent.topKFrequentBruteForce(new int[]{1, 1, 1, 2, 2, 5}, 2);
        int[] optimalResult = kFrequent.topKFrequentOptimal(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        System.out.println(Arrays.toString(bruteForceResult));
        System.out.println(Arrays.toString(optimalResult));
    }
}
