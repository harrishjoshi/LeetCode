class Solution:
    """
    @param: strs: a list of strings
    @return: encodes a list of strings to a single string.
    """
    def encode(self, strs):
        result = ""

        # Encode each string in the list
        for s in strs:
            # Encode current string with the length of the string, # and the string itself
            encoded_str = str(len(s)) + "#" + s
            result += encoded_str

        return result

    """
    @param: str: A string
    @return: decodes a single string to a list of strings
    """
    def decode(self, str):
        # Initialize result list and index to store index of the substring
        result, i = [], 0

        # Decode the string
        while i < len(str):
            j = i

            # Find the end of the current substring
            while str[j] != "#":
                j += 1

            # Get the length of the substring
            length = int(str[i:j])

            # Calculate the end index of the substring
            str_end = j + 1 + length

            # Append the decoded substring to the result list
            result.append(str[j+1:str_end])

            # Move to the next substring
            i = str_end

        return result

# Test Cases
test = Solution()
input = ["hello", "world"]
print("Input:", input)
encoded_input = test.encode(input)
print("Encoded:", encoded_input)
print("Decoded:", test.decode(encoded_input))