public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] alpha, int[] beta) {
        int mid = (alpha.length + beta.length) / 2 + 1; // char mid = (char) ((alpha.length + beta.length) / 2 + 1);
        int[] last = new int[2];
        int a = 0; // char a = 0
        int b = 0; // char b = 0
        while (a + b < mid) {
            last[1] = last[0];
            if ((a < alpha.length) && (b < beta.length)) {
                if (alpha[a] < beta[b]) {
                    last[0] = alpha[a++];
                } else {
                    last[0] = beta[b++];
                }
            } else if (a == alpha.length) {
                last[0] = beta[b++];
            } else {
                last[0] = alpha[a++];
            }
        }
        if ((alpha.length + beta.length) % 2 == 1) {
            return last[0];
        } else {
            return (last[0] + last[1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1}, new int[] {3,4,5}));
    }
}
