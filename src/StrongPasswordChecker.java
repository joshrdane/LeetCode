public class StrongPasswordChecker {
    public static int strongPasswordChecker(String password) {
        return 0;
    }

    public static void main(String[] args) {
        for (String testCase : new String[] {"a", "aA1", "1337C0d3", "aaa111", "aBcD3FgHiJkLmNoPqRsTuVwXyZ"}) {
            System.out.println(strongPasswordChecker(testCase));
        }
    }
}
