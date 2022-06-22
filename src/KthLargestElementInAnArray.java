import java.util.Arrays;

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}