public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Integer.max(sum + num, num);
            max = Math.max(sum, max);
        }
        return max;
    }
}
