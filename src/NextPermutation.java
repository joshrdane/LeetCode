public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        int right = nums.length - 1;
        while (left >= 0 && nums[left + 1] <= nums[left]) {
            left--;
        }
        if (left >= 0) {
            while (nums[right] <= nums[left]) {
                right--;
            }
            swap(nums, left, right);
        }
        left++;
        right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        if (nums[a] != nums[b]) {
            nums[a] ^= nums[b];
            nums[b] ^= nums[a];
            nums[a] ^= nums[b];
        }
    }
}
