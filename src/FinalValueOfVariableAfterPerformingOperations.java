public class FinalValueOfVariableAfterPerformingOperations {
    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            switch (operation) {
                case "++X", "X++" -> result++;
                case "--X", "X--" -> result--;
            }
        }
        return result;
    }
}
