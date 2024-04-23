class Solution:
    """
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.
    Example:
    Input: s = "anagram", t = "nagaram"
    Output: true
    """

    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        # Create dictionaries to store the characters and their frequencies
        s_characters, t_characters = {}, {}
        for i in range(len(s)):
            s_char = s[i]
            t_char = t[i]
            s_characters[s_char] = s_characters.get(s_char, 0) + 1
            t_characters[t_char] = t_characters.get(t_char, 0) + 1

        # Compare the dictionaries
        for key in s_characters:
            if s_characters[key] != t_characters.get(key, 0):
                return False

        return True

    def isAnagramWithSorting(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        return sorted(s) == sorted(t)

# test cases
test = Solution()
print(test.isAnagram("anagram", "nagaram"))
print(test.isAnagramWithSorting("rat", "car"))