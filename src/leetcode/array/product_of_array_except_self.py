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
                # Skip self multiplication
                if i != j:
                    product *= nums[j]
            result.append(product)

        return result

    def productExceptSelfOptimal(self, nums):
        result = [1] * (len(nums))

        prefix = 1
        for i in range(len(nums)):
            result[i] = prefix
            prefix *= nums[i] 

        postfix = 1
        for i in range(len(nums) - 1, -1, -1):
            result[i] *= postfix
            postfix *= nums[i]

        return result

# Test Cases
test = Solution()
print(test.productExceptSelfBruteForce([-1, 1, 0, -3, 3]))
print(test.productExceptSelfOptimal([1, 2, 3, 4]))