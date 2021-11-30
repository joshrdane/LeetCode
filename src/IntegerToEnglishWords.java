public class IntegerToEnglishWords {
    final private static int BILLION = 1000000000;
    final private static int MILLION = 1000000;
    final private static int THOUSAND = 1000;
    final private static int HUNDRED = 100;
    final private static int TEN = 10;

    public static String numberToWords(int number) {
        StringBuilder builder = new StringBuilder();
        if (number == 0) {
            builder.append("Zero");
        }
        if (number >= BILLION) {
            builder.append(hundredsToWords(number / BILLION));
            builder.append("Billion ");
            number %= BILLION;
        }
        if (number >= MILLION) {
            builder.append(hundredsToWords(number / MILLION));
            builder.append("Million ");
            number %= MILLION;
        }
        if (number >= THOUSAND) {
            builder.append(hundredsToWords(number / THOUSAND));
            builder.append("Thousand ");
            number %= THOUSAND;
        }
        builder.append(hundredsToWords(number));
        return builder.toString().trim();
    }

    private static String hundredsToWords(int number) {
        StringBuilder builder = new StringBuilder();
        int hundreds = number / HUNDRED;
        number %= HUNDRED;
        if (hundreds > 0) {
            builder.append(digitsToString(hundreds));
            builder.append("Hundred ");
        }
        int tens = number / TEN;
        if (tens == 1) {
            switch (number) {
                case 10 -> builder.append("Ten ");
                case 11 -> builder.append("Eleven ");
                case 12 -> builder.append("Twelve ");
                case 13 -> builder.append("Thirteen ");
                case 14 -> builder.append("Fourteen ");
                case 15 -> builder.append("Fifteen ");
                case 16 -> builder.append("Sixteen ");
                case 17 -> builder.append("Seventeen ");
                case 18 -> builder.append("Eighteen ");
                case 19 -> builder.append("Nineteen ");
            }
        } else {
            switch (tens) {
                case 2 -> builder.append("Twenty ");
                case 3 -> builder.append("Thirty ");
                case 4 -> builder.append("Forty ");
                case 5 -> builder.append("Fifty ");
                case 6 -> builder.append("Sixty ");
                case 7 -> builder.append("Seventy ");
                case 8 -> builder.append("Eighty ");
                case 9 -> builder.append("Ninety ");
            }
            number %= TEN;
            builder.append(digitsToString(number));
        }
        return builder.toString();
    }
    private static String digitsToString(int number) {
        StringBuilder builder = new StringBuilder();
        switch (number) {
            case 1 -> builder.append("One ");
            case 2 -> builder.append("Two ");
            case 3 -> builder.append("Three ");
            case 4 -> builder.append("Four ");
            case 5 -> builder.append("Five ");
            case 6 -> builder.append("Six ");
            case 7 -> builder.append("Seven ");
            case 8 -> builder.append("Eight ");
            case 9 -> builder.append("Nine ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(numberToWords(1000));
        System.out.println(numberToWords(100000));
    }
}
