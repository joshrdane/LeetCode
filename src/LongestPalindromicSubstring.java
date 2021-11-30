public class LongestPalindromicSubstring {
    public static String longestPalindrome(String string) {
        int index = 0;
        int length = 0;
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + length; j < string.length(); j++) {
                String substring = string.substring(i, j + 1);
                if (isPalindrome(substring)) {
                    length = substring.length();
                    index = i;
                }
            }
        }
        return string.substring(index, index + length);
    }

    public static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
