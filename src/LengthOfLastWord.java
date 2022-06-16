public class LengthOfLastWord {
    public static int lengthOfLastWord(String string) {
        int end = string.length() - 1;
        for (; end >= 0; end--) {
            if (string.charAt(end) != ' ') {
                break;
            }
        }
        int start = end - 1;
        for (; start >= 0; start--) {
            if (string.charAt(start) == ' ') {
                break;
            }
        }
        return end - start;
    }
}
