package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is
 * decoded back to the original list of strings.
 * Example:
 * Input: ["Hello", "World"]
 * Output: ["Hello", "World"]
 * Explanation: The input string is already encoded, so the encoded string will be sent.
 * ["Hello", "World"] --> ["Hello", "World"]
 */
public class EncodeAndDecodeStrings {

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String s : strs) {
            String encoded_str = s.length() + "#" + s;
            result.append(encoded_str);
        }

        return result.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            int strEnd = j + length + 1;
            result.add(str.substring(j + 1, strEnd));
            i = strEnd;
        }

        return result;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings ed = new EncodeAndDecodeStrings();
        List<String> input = List.of("Hello", "World");
        System.out.println("Input: " + input);

        String encoded = ed.encode(input);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = ed.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}