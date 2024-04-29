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
                // Skip the same element multiplication
                if (i != j) {
                    product *= nums[j];
                }
            }

            // Store the product of all elements except the element at i
            result[i] = product;
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
        int[] product = test.productExceptSelfBruteForce(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(product));
    }
}