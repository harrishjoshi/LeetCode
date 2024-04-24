class Solution:
    """
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    Example:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    """

    def twoSumBruteForce(self, nums, target):
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

        return None

    def twoSumOptimal(self, nums, target):
        complement_map = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in complement_map:
                return [complement_map[complement], i]
            complement_map[nums[i]] = i

        return None

# Test cases
test = Solution()
nums = [2, 7, 11, 15]
print(test.twoSumBruteForce(nums, 9))
print(test.twoSumOptimal(nums, 13))