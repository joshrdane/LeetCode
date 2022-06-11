public class MinimumOperationsToReduceXToZero {
    /**
     * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
     *
     * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
     * @param nums Input array of integers
     * @param x Target number
     * @return Minimum # of operations or -1 if not possible.
     */
    public static int minOperations(int[] nums, int x) {
        // `left` and `right` pointers are set to the outside bounds of the array
        int left = -1;
        int right = nums.length;
        // `min` is the minimum number of operations
        int min = Integer.MAX_VALUE;
        // adding 2 is necessary since the pointers are out of bounds
        // left + 1 <= right - 1  ===  left + 2 <= right
        while (left + 2 <= right) {
            if (nums[right - 1] <= x) {
                // consume the rightmost unconsumed element and update pointer
                x -= nums[--right];
            } else if (left + 1 != nums.length) {
                // consume the leftmost unconsumed element and update pointer
                x -= nums[++left];
                // adjust `x` by un-consuming elements previously consumed by the `right` pointer
                while (x < 0 && right < nums.length) {
                    x += nums[right++];
                }
            } else {
                // break when `left` would reach out of bounds
                break;
            }
            if (x == 0) {
                // hit the target of 0, update the `min`
                min = Math.min(left + nums.length - right + 1, min);
            }
        }
        // return -1 if min was never changed
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {1, 1, 4, 2, 3}, 5));
        System.out.println(minOperations(new int[] {5, 6, 7, 8, 9}, 4));
        System.out.println(minOperations(new int[] {3, 2, 20, 1, 1, 3}, 10));
        System.out.println(minOperations(new int[] {1, 1}, 3));
        System.out.println(minOperations(new int[] {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));
        System.out.println(minOperations(new int[] {5207,5594,477,6938,8010,7606,2356,6349,3970,751,5997,6114,9903,3859,6900,7722,2378,1996,8902,228,4461,90,7321,7893,4879,9987,1146,8177,1073,7254,5088,402,4266,6443,3084,1403,5357,2565,3470,3639,9468,8932,3119,5839,8008,2712,2735,825,4236,3703,2711,530,9630,1521,2174,5027,4833,3483,445,8300,3194,8784,279,3097,1491,9864,4992,6164,2043,5364,9192,9649,9944,7230,7224,585,3722,5628,4833,8379,3967,5649,2554,5828,4331,3547,7847,5433,3394,4968,9983,3540,9224,6216,9665,8070,31,3555,4198,2626,9553,9724,4503,1951,9980,3975,6025,8928,2952,911,3674,6620,3745,6548,4985,5206,5777,1908,6029,2322,2626,2188,5639}, 565610));
    }
}
