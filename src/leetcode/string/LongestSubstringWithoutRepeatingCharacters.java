package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstringBruteForce(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isUnique(substring)) {
                    if (substring.length() > maxLength) {
                        maxLength = substring.length();
                    }
                }
            }
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringOptimal(String s) {
        HashMap<Character, Integer> charactersMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (charactersMap.containsKey(currentChar)) {
                start = Math.max(start, charactersMap.get(currentChar) + 1);
            }

            charactersMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    private boolean isUnique(String substring) {
        HashSet<Character> chars = new HashSet<>();
        for (char c : substring.toCharArray()) {
            if (chars.contains(c)) {
                return false;
            }

            chars.add(c);
        }

        return true;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ls.lengthOfLongestSubstringBruteForce("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstringOptimal("abcabcbb"));
    }
}
