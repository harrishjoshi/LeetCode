"""
 Given a string s, find the length of the longest substring without repeating characters.
 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
"""

# Bruteforce approach
# Time complexity: O(n^3)
# Space complexity: O(min(n, m)), where n is the length of the string and m is the size of the character set
def brute_force(s):
    n = len(s)
    max_len = 0
    for i in range(n):
        for j in range(i, n):
            if is_unique(s[i:j+1]):
                max_len = max(max_len, len(s[i:j+1]))

    return max_len

def is_unique(s):
    return len(s) == len(set(s))

# Optimal approach
# Time complexity: O(n)
# Space complexity: O(min(n, m)), where n is the length of the string and m is the size of the character set
def optimal(s):
    n = len(s)
    max_len = 0
    char_map = {}
    start = 0

    for end in range(n):
        if s[end] in char_map:
            start = max(start, char_map[s[end]] + 1)

        #print('char_map:', char_map, 's[end]:', s[end], 'start:', start, 'end:', end)
        char_map[s[end]] = end
        max_len = max(max_len, end - start + 1)

    return max_len

# Test cases
print('Bruteforce:', brute_force("abcabcbb"))
print('Optimal:', optimal("abcabcbb"))