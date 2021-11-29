import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String string) {
        int longest = 0;
        int left = 0;
        int right = 0;
        while (right < string.length()) {
            if (string.substring(left, right).indexOf(string.charAt(right)) < 0) {
                right++;
                if (right - left > longest) {
                    longest = right - left;
                }
            } else {
                left++;
                if (left > right) {
                    right = left;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> testCases = new HashMap<>();
        testCases.put("", 0);
        testCases.put(" ", 1);
        testCases.put("aa", 1);
        testCases.put("abcabcabc", 3);
        testCases.put("asdfgfdsa", 5);
        for (String testCase : testCases.keySet()) {
            int result = lengthOfLongestSubstring(testCase);
            if (testCases.get(testCase) != result) {
                System.out.printf("FAIL EXPECTED: %d RESULT: %d CASE: \"%s\"%n", testCases.get(testCase), result, testCase);
            }
        }
    }
}
