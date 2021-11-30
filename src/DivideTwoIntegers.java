public class DivideTwoIntegers {
    /**
     * Divides two numbers without using division, multiplication, or the mod operator.
     * Answers are truncated.
     * Apparently this is too slow for leetcode
     *
     * @param dividend
     * @param divisor
     * @return dividend/divisor
     */
    public static int oldDivide(int dividend, int divisor) {
        int result = 0;
        if (dividend < 0) {
            if (divisor < 0) {
                while (dividend <= divisor) {
                    dividend -= divisor;
                    if (result < Integer.MAX_VALUE) {
                        result++;
                    } else {
                        break;
                    }
                }
            } else {
                while (dividend <= -divisor) {
                    dividend += divisor;
                    if (result > Integer.MIN_VALUE) {
                        result--;
                    } else {
                        break;
                    }
                }
            }
        } else {
            if (divisor < 0) {
                while (dividend >= -divisor) {
                    dividend += divisor;
                    if (result > Integer.MIN_VALUE) {
                        result--;
                    } else {
                        break;
                    }
                }
            } else {
                while (dividend >= divisor) {
                    dividend -= divisor;
                    if (result < Integer.MAX_VALUE) {
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
