import java.util.ArrayList;

public class ValidAnagram {
    /**
     * Version 1
     *
     * @param stringOne
     * @param stringTwo
     * @return
     */
    public static boolean oldIsAnagram(String stringOne, String stringTwo) {
        if (stringOne.length() != stringTwo.length()) {
            return false;
        }
        ArrayList<Character> one = new ArrayList<>();
        for (char c : stringOne.toCharArray()) {
            one.add(c);
        }
        for (char c : stringTwo.toCharArray()) {
            int index = one.indexOf(c);
            if (index >= 0) {
                one.remove(index);
            } else {
                return false;
            }
        }
        return true;
    }

    // Pre-sorting would probably be better
    /**
     * Version 2
     *
     * @param stringOne
     * @param stringTwo
     * @return
     */
    public static boolean isAnagram(String stringOne, String stringTwo) {
        char[] one = stringOne.toCharArray();
        char[] two = stringTwo.toCharArray();
        if (one.length != two.length) {
            return false;
        }
        int size = one.length;
        for (char c : two) {
            for (int j = 0; j < size; j++) {
                if (c == one[j]) {
                    char temp = one[j];
                    one[j] = one[size - 1];
                    one[size - 1] = temp;
                    size--;
                    break;
                }
            }
        }
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aba", "aab"));
    }
}
