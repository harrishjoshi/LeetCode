package leetcode.array;

import leetcode.string.ValidAnagram;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Example:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagramsBruteForce(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            // Skip if the string is already grouped
            if (s == null) {
                continue;
            }

            List<String> anagrams = new ArrayList<>();
            // Add the current string to the group
            anagrams.add(s);

            for (int j = i + 1; j < strs.length; j++) {
                String t = strs[j];
                // Skip if the string is already grouped
                if (t == null) {
                    continue;
                }

                // Check if the strings are anagrams
                boolean isAnagram = ValidAnagram.isAnagramOptimal(s, t);
                if (isAnagram) {
                    anagrams.add(t);
                    // Mark the string as grouped
                    strs[j] = null;
                }
            }

            // Add the group to the result
            groupedAnagrams.add(anagrams);
        }

        return groupedAnagrams;
    }

    public List<List<String>> groupAnagramsOptimal(String[] strs) {
        // Map to store the grouped anagrams
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String s : strs) {
            // Sort the string to group the anagrams
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            // Add the string to the group
            String key = new String(chars);
            if (!groupedAnagrams.containsKey(key)) {
                groupedAnagrams.put(key, new ArrayList<>());
            }
            groupedAnagrams.get(key).add(s);
        }

        // Return the grouped anagrams as a list
        return new ArrayList<>(groupedAnagrams.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> groupedAnagramsBruteForce =
                groupAnagrams.groupAnagramsBruteForce(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> groupedAnagramsOptimal =
                groupAnagrams.groupAnagramsOptimal(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(groupedAnagramsBruteForce);
        System.out.println(groupedAnagramsOptimal);
    }
}
