public class ValidNumber {
    public static boolean isNumber(String string) {
        string = string.toLowerCase();
        boolean dot = false;
        boolean e = false;
        boolean signAllowed = true;
        boolean eAllowed = false;
        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
                case 'e':
                    if (!eAllowed || e) {
                        return false;
                    }
                    eAllowed = false;
                    e = true;
                    signAllowed = true;
                    break;
                case '.':
                    if (e || dot) {
                        return false;
                    }
                    eAllowed = false;
                    dot = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    signAllowed = false;
                    if (dot || i == 0) {
                        eAllowed = true;
                    }
                    break;
                case '-':
                case '+':
                    if (!signAllowed) {
                        return false;
                    }
                    if (dot || i == 0) {
                        eAllowed = true;
                    } else {
                        eAllowed = false;
                    }
                    signAllowed = false;
                    break;
                default:
                    return false;
            }
        }
        if ((dot && string.length() == 1) ||
                (string.charAt(string.length() - 1) == 'e') ||
                (string.charAt(string.length() - 1) == '+') ||
                (string.charAt(string.length() - 1) == '-')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (String testCase : new String[] {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"}) {
            System.out.println(testCase);
            System.out.println(isNumber(testCase));
        }
    }
}
