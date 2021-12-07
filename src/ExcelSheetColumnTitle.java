public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber-- > 0) {
            result.insert(0, ((char) (columnNumber % 26 + 65)));
            columnNumber /= 26;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(2147483647));
    }
}
