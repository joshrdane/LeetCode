public class NonDecreasingArray {
    public static boolean checkPossibility(int[] nums) {
        boolean modified = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (modified) {
                    return false;
                }
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                modified = true;
            }
        }
        return true;
    }
}
