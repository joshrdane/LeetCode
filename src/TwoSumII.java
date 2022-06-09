public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[] {0, numbers.length - 1};
        int value;
        do {
            value = numbers[result[0]] + numbers[result[1]];
            if (value < target) {
                result[0]++;
                if (result[0] == result[1]) {
                    result[1]++;
                }
            } else if (value > target) {
                result[1]--;
                if (result[0] == result[1]) {
                    result[0]--;
                }
            }
        } while (value != target);
        result[0]++;
        result[1]++;
        return result;
    }
}
