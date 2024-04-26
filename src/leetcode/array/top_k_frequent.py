class Solution:
    """
     Given a non-empty array of integers, return the k most frequent elements.
     Example:
     Input: nums = [1,1,1,2,2,3], k = 2
     Output: [1,2]
    """

    def topKFrequentBruteForce(self, nums, k):
        if len(nums) == k:
            return nums

        # Count the frequency of each element
        frequent_counts = {}
        for num in nums:
            # Update the count of the element
            frequent_counts[num] = frequent_counts.get(num, 0) + 1

        # Initialize the result list
        result = list(range(k))
        for i in range(k):
            # Initialize the max count and key
            max_count = 0
            max_key = 0

            # Find the key with the maximum count
            for key, value in frequent_counts.items():
                # Update the max count and key
                if value > max_count:
                    max_count = value
                    max_key = key

            # Update the result list
            result[i] = max_key
            # Remove the key from the dictionary
            del frequent_counts[max_key]

        return result

# Test Cases
test = Solution()
print(test.topKFrequentBruteForce([1, 1, 1, 2, 2, 5], 2))