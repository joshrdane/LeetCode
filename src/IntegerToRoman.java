public class IntegerToRoman {
    public static String intToRoman(int number) {
        StringBuilder builder = new StringBuilder();
        while (number >= 1000) {
            builder.append('M');
            number -= 1000;
        }
        while (number >= 900) {
            builder.append("CM");
            number -= 900;
        }
        while (number >= 500) {
            builder.append('D');
            number -= 500;
        }
        while (number >= 400) {
            builder.append("CD");
            number -= 400;
        }
        while (number >= 100) {
            builder.append('C');
            number -= 100;
        }
        while (number >= 90) {
            builder.append("XC");
            number -= 90;
        }
        while (number >= 50) {
            builder.append('L');
            number -= 50;
        }
        while (number >= 40) {
            builder.append("XL");
            number -= 40;
        }
        while (number >= 10) {
            builder.append('X');
            number -= 10;
        }
        while (number >= 9) {
            builder.append("IX");
            number -= 9;
        }
        while (number >= 5) {
            builder.append('V');
            number -= 5;
        }
        while (number >= 4) {
            builder.append("IV");
            number -= 4;
        }
        while (number >= 1) {
            builder.append('I');
            number -= 1;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
