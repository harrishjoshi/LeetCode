class Solution:
    """
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
    Example:
    Input: nums = [1,2,3,1]
    Output: true
    """

    def containsDuplicateBruteForce(self, nums) -> bool:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] == nums[j]:
                    return True
        return False

    def containsDuplicateOptimal(self, nums) -> bool:
        visitedNumbersMap = dict()
        for i in range(len(nums)):
            if nums[i] in visitedNumbersMap.keys():
                return True
            visitedNumbersMap[nums[i]] = i

        return False

# test cases
test = Solution()
print(test.containsDuplicateBruteForce([1,2,3,1]))
print(test.containsDuplicateOptimal([1,2,3,4]))