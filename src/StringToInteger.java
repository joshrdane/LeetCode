public class StringToInteger {
    public static int myAtoi(String string) {
        int result = 0;
        boolean negative = false;
        boolean parsingInteger = false;
        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
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
                    parsingInteger = true;
                    result *= 10;
                    result += string.charAt(i) - '0';
                    if ((negative) && (-result > 0)) {
                        return Integer.MIN_VALUE;
                    } else if ((!negative) && (result < 0)) {
                        return Integer.MAX_VALUE;
                    }
                    break;
                case '-':
                    if (parsingInteger) {
                        return result;
                    }
                    parsingInteger = true;
                    negative = true;
                    break;
                case ' ':
                    if (parsingInteger) {
                        return result;
                    }
                    break;
                default:
                    return result;
            }
        }
        if (negative) {
            return -result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("2147483648"));
    }
}
