package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Create a map of characters and their counts for both strings
        Map<Character, Integer> sCharacters = new HashMap<>();
        Map<Character, Integer> tCharacters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sCharacters.put(sChar, sCharacters.getOrDefault(sChar, 0) + 1);
            tCharacters.put(tChar, tCharacters.getOrDefault(tChar, 0) + 1);
        }

        // Compare the character counts of both strings
        for (Map.Entry<Character, Integer> entry : sCharacters.entrySet()) {
            char key = entry.getKey();
            int sCount = entry.getValue();
            int tCount = tCharacters.getOrDefault(key, 0);
            if (sCount != tCount) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramWithSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        // Sort the character arrays
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Compare the sorted character arrays
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("anagram", "nagaram"));
        System.out.println(va.isAnagramWithSorting("rat", "car"));
    }
}
