import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public static int minMoves2(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            moves += Math.abs(num - nums[nums.length / 2]);
        }
        return moves;
    }
}
