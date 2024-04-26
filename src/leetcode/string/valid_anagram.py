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

    def isAnagramOptimal(self, s: str, t: str):
        # If the lengths of the strings are different, they can't be anagrams
        if len(s) != len(t):
            return False

        # Create a list of 26 integers to store the count of each character
        alphabet = [0] * 26
        for char in s:
            # Increment the count of the character in the alphabet list
            # "a" is at index 0, "b" is at index 1, and so on
            alphabet[ord(char) - ord('a')] += 1

        for char in t:
            # Decrement the count of the character in the alphabet list
            alphabet[ord(char) - ord('a')] -= 1

        # If the strings are anagrams, the alphabet list should have all 0s
        for count in alphabet:
            if count != 0:
                return False

        return True

# test cases
# test = Solution()
# print(test.isAnagram("anagram", "nagaram"))
# print(test.isAnagramOptimal("ram", "mar"))
# print(test.isAnagramWithSorting("rat", "car"))