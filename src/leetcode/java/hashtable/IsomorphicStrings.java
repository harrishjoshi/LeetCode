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

    /**
     * Checks if strings s and t are isomorphic using a HashMap for one-to-one mapping.
     *
     * @param s First string
     * @param t Second string
     * @return true if isomorphic, false otherwise
     */
    public static boolean isIsomorphic1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check if c2 is mapped to a different character
            Character existingKey = getKey(charMap, c2);
            if (existingKey != null && existingKey != c1) {
                return false;
            }

            if (charMap.containsKey(c1)) {
                // Ensure c1 maps consistently to c2
                if (c2 != charMap.get(c1)) {
                    return false;
                }
            } else {
                // Add new mapping
                charMap.put(c1, c2);
            }
        }

        return true;
    }

    /**
     * Gets the key mapped to the target value for reverse lookup.
     *
     * @param charMap The character mapping
     * @param target  The value to find
     * @return The key or null if not found
     */
    public static Character getKey(Map<Character, Character> charMap, Character target) {
        for (Map.Entry<Character, Character> entry : charMap.entrySet()) {
            if (entry.getValue().equals(target)) {
                return entry.getKey();
            }
        }

        return null;
    }

    /**
     * Checks if strings s and t are isomorphic using arrays for mapping.
     *
     * @param s First string
     * @param t Second string
     * @return true if isomorphic, false otherwise
     */
    public static boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] mapS = new int[128]; // Tracks s chars
        int[] mapT = new int[128]; // Tracks t chars

        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }

            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic1("foo", "bar"));
        System.out.println(isIsomorphic2("paper", "title"));
    }
}
