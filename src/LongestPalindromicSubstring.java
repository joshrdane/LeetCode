public class LongestPalindromicSubstring {
    public static String oldLongestPalindrome(String string) {
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

    public static String longestPalindrome(String string) {
        return longestPalindrome(string.toCharArray());
    }

    public static String longestPalindrome(char[] array) {
        int index = 0;
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + length; j < array.length; j++) {
                if (isPalindrome(array, i, j)) {
                    length = j - i + 1;
                    index = i;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = index; i < index + length; i++) {
            builder.append(array[i]);
        }
        return builder.toString();
    }

    public static boolean isPalindrome(char[] array) {
        return isPalindrome(array, 0, array.length - 1);
    }

    public static boolean isPalindrome(char[] array, int start, int end) {
        for (int i = start; i < start + (end - start) / 2; i++) {
            System.out.println(i);
            if (array[i] != array[end - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abad"));
    }
}
