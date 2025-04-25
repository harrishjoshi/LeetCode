package leetcode.java.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * <p>
 * LeetCode problem: <a href="https://leetcode.com/problems/isomorphic-strings/description/">Isomorphic Strings</a>
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check if c2 is already mapped to a different character (ensures one-to-one mapping)
            Character existingKey = getKey(charMap, c2);
            if (existingKey != null && existingKey != c1) {
                return false;
            }

            if (charMap.containsKey(c1)) {
                // Check if c1 consistently maps to c2
                if (c2 != charMap.get(c1)) {
                    return false;
                }
            } else {
                // Add new mapping from c1 to c2
                charMap.put(c1, c2);
            }
        }

        // True, if all the character mappings are consistent
        return true;
    }

    /**
     * Retrieves the key from the map that maps to the given target value.
     * Used to check for duplicate values in the map (reverse lookup).
     */
    public static Character getKey(Map<Character, Character> charMap, Character target) {
        for (Map.Entry<Character, Character> entry : charMap.entrySet()) {
            if (entry.getValue().equals(target)) {
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }
}
