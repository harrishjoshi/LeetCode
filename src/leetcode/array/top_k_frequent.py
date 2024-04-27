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
    
    def kTopFrequentOptimal(self, nums, k):
        number_counts = {}
        # Initialize the count frequencies list with empty lists
        count_frequencies = [[] for i in range(len(nums) + 1)]

        # Count the frequency of each element
        for num in nums:
            number_counts[num] = number_counts.get(num, 0) + 1

        # Update the count frequencies list
        for num, count in number_counts.items():
            # Append the number to the count frequencies list at the count index
            count_frequencies[count].append(num)

        # Initialize the result list
        result = []
        # Iterate through the count frequencies list in reverse order
        for i in range(len(count_frequencies) - 1, 0, -1):
            # Append the numbers to the result list
            for num in count_frequencies[i]:
                result.append(num)
                # Break the loop if the result list has k elements
                if len(result) == k:
                    return result

        return result
# Test Cases
test = Solution()
print(test.topKFrequentBruteForce([1, 1, 1, 2, 2, 5], 2))
print(test.kTopFrequentOptimal([4, 1, -1, 2, -1, 2, 3], 2))