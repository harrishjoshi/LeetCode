"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
"""

# Bruteforce approach
# Time complexity: O(n^2)
# Space complexity: O(1)
def two_sum_brute_force(nums, target):
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]
    return [] # No solution

# Optimal approach
# Time complexity: O(n)
# Space complexity: O(n)
def two_sum_optimal(nums, target):
    complement_map = {}
    for i in range(len(nums)):
        complement = target - nums[i]
        if complement in complement_map:
            return [complement_map[complement], i]
        complement_map[nums[i]] = i
    return [] # No solution

# Test cases
nums = [2, 7, 11, 15]
target = 9
print('Brute Force: ', two_sum_brute_force(nums, target))
print('Optimal: ', two_sum_optimal(nums, target))