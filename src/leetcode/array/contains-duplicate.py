class Solution:
    """
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
    Example:
    Input: nums = [1,2,3,1]
    Output: true
    """

    # Time complexity: O(n^2)
    # Space complexity: O(1)
    def containsDuplicateBruteForce(self, nums) -> bool:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] == nums[j]:
                    return True
        return False

    # Time complexity: O(n)
    # Space complexity: O(n)
    def containsDuplicateOptimal(self, nums) -> bool:
        numsHashSet = set()
        for n in nums:
            if n in numsHashSet:
                return True
            numsHashSet.add(n)
        return False

# test cases
test = Solution()
print(test.containsDuplicateBruteForce([1,2,3,1]))
print(test.containsDuplicateOptimal([1,2,3,4]))