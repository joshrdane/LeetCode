import java.lang.reflect.Array;
import java.util.HashMap;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int score = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (find(nums, nums[right], left, right) < 0) {
                right++;
                int temp = 0;
                for (int i = left; i < right; i++) {
                    temp += nums[i];
                }
                if (temp > score) {
                    score = temp;
                }
            } else {
                left++;
                if (left > right) {
                    right = left;
                }
            }
        }
        return score;
    }

    private static int find(int[] array, int value, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
