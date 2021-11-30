public class RomanToInteger {
    public static int romanToInt(String string) {
        int result = 0;
        char last = '.';
        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    if (last == 'I') {
                        result += 3;
                    } else {
                        result += 5;
                    }
                    break;
                case 'X':
                    if (last == 'I') {
                        result += 8;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    if (last == 'X') {
                        result += 30;
                    } else {
                        result += 50;
                    }
                    break;
                case 'C':
                    if (last == 'X') {
                        result += 80;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    if (last == 'C') {
                        result += 300;
                    } else {
                        result += 500;
                    }
                    break;
                case 'M':
                    if (last == 'C') {
                        result += 800;
                    } else {
                        result += 1000;
                    }
                    break;
            }
            last = string.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
