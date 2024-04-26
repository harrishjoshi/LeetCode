import sys
sys.path.append('src/leetcode/string')
from valid_anagram import Solution as anagram

class Solution:
    """
     Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     typically using all the original letters exactly once.
     Example:
     Input: strs = ["eat","tea","tan","ate","nat","bat"]
     Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    """

    def groupAnagramsBruteForce(self, strs):
        grouped_anagrams = []
        for i in range(len(strs)):
            # Check if the element is already grouped
            s = strs[i]
            if s == None:
                continue

            # Add the first element in the list
            anagrams = [s]
            for j in range(i+1, len(strs)):
               t = strs[j]
               # Check if the element is already grouped
               if t == None:
                   continue

                # Check if the element is an anagrams
               if anagram.isAnagramOptimal(self, s, t) == True:
                   anagrams.append(t)
                   # Mark the element as grouped
                   strs[j] = None

            # Add the grouped anagrams
            grouped_anagrams.append(anagrams)

        return grouped_anagrams

# Test Cases
test = Solution()
print(test.groupAnagramsBruteForce(["eat","tea","tan","ate","nat","bat"]))