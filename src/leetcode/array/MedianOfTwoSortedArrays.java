package leetcode.array;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        // Create new array to merge both arrays with total size of first and second array
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        // Merge until one of the arrays is fully traversed
        while (i < nums1.length && j < nums2.length) {
            // Compare the current elements from nums1 and nums2.
            // Ensure that the merged array remains sorted in non-decreasing order,
            // which is essential for finding the median efficiently.
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Add remaining elements from nums1 if any
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        // Add remaining elements from nums2 if any
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        // Calculate the median based on the length of the merged array
        int totalLength = merged.length;
        int medianIndex = totalLength / 2;
        // If the total length is even, return the average of the two median elements
        if (isEven(totalLength)) {
            return (merged[medianIndex - 1] + merged[medianIndex]) / 2.0;
        }

        // If the total length is odd, return the median element
        return merged[medianIndex];
    }

    private static boolean isEven(int totalLength) {
        return totalLength % 2 == 0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double result = medianOfTwoSortedArrays.findMedianSortedArraysBruteForce(nums1, nums2);
        System.out.println(result);
    }
}