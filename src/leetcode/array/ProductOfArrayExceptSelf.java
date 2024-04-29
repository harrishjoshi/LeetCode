package leetcode.array;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelfBruteForce(int[] nums) {
        // Create an array to store the product of all elements except the element at i
        int[] result = new int[nums.length];

        // For each element in the array, multiply all elements except the current element
        for (int i = 0; i < nums.length; i++) {
            int product = 1;

            // Multiply all elements except the element at i
            for (int j = 0; j < nums.length; j++) {
                // Skip self multiplication
                if (i != j) {
                    product *= nums[j];
                }
            }

            // Store the product of all elements except the element at i
            result[i] = product;
        }

        return result;
    }

    public int[] productExceptSelfOptimal(int[] nums) {
        int[] result = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
        int[] bruteForce = test.productExceptSelfBruteForce(new int[]{-1, 1, 0, -3, 3});
        int[] optimal = test.productExceptSelfOptimal(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(bruteForce));
        System.out.println(Arrays.toString(optimal));
    }
}