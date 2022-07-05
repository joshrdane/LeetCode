import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int num : numbers) {
            numberSet.add(num);
        }

        int longestStreak = 0;
        for (int number : numberSet) {
            if (!numberSet.contains(number - 1)) {
                int currentNumber = number;
                int currentStreak = 1;

                while (numberSet.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
