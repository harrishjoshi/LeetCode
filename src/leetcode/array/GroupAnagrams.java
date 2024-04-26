package leetcode.array;

import leetcode.string.ValidAnagram;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> groupedAnagrams = groupAnagrams.groupAnagramsBruteForce(strs);
        System.out.println(groupedAnagrams);
    }
}
