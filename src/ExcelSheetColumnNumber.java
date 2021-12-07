public class ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result *= 26;
            result += columnTitle.charAt(i) - 64;
        }
        return result;
    }

    public static void main(String[] args) {
        for (String testCase : new String[] {"A", "AB", "ZY", "FXSHRXW"}) {
            System.out.println(titleToNumber(testCase));
        }
    }
}
