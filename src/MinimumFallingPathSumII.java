public class MinimumFallingPathSumII {
    public static int minFallingPathSum(int[][] matrix) {
        for (int row = matrix.length - 2; row >= 0; row--) {
            for (int column = 0; column < matrix[row].length; column++) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < matrix[row + 1].length; i++) {
                    if (i != column) {
                        min = Math.min(min, matrix[row + 1][i]);
                    }
                }
                matrix[row][column] += min;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int value : matrix[0]) {
            result = Math.min(result, value);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][] {{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{97,91,61,-46,67}}));
    }
}
