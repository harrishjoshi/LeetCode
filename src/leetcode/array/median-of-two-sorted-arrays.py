"""
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Example:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
"""

# Bruteforce approach
# Time complexity: O(m + n)
# Space complexity: O(m + n)
def brute_force(nums1, nums2):
    merged = []
    i, j = 0, 0

    while (i < len(nums1) and j < len(nums2)):
        if nums1[i] < nums2[j]:
            merged.append(nums1[i])       
            i += 1
        else:
            merged.append(nums2[j])       
            j += 1

    while i < len(nums1):
        merged.append(nums1[i]) 
        i += 1

    while j < len(nums2):
        merged.append(nums2[j])     
        j += 1

    totalLength = len(merged)
    medianIndex = totalLength // 2
    if totalLength % 2 == 0:
        return (merged[medianIndex - 1] + merged[medianIndex]) / 2.0

    return merged[medianIndex]

# Test cases
print(brute_force([1, 2], [3, 4]))