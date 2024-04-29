class Solution:
    """
    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
    of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
    Example:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]
    """

    def productExceptSelfBruteForce(self, nums):
        result = []

        for i in range(len(nums)):
            product = 1
            for j in range(len(nums)):
                # Skip the same element multiplication
                if i != j:
                    product *= nums[j]
            result.append(product)

        return result

# Test Cases
test = Solution()
print(test.productExceptSelfBruteForce([-1,1,0,-3,3]))