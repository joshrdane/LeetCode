public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        for (int row = matrix.length - 2; row >= 0; row--) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (column == 0) {
                    matrix[row][column] += Math.min(matrix[row + 1][column], matrix[row + 1][column + 1]);
                } else if (column == matrix[row].length - 1) {
                    matrix[row][column] += Math.min(matrix[row + 1][column - 1], matrix[row + 1][column]);
                } else {
                    matrix[row][column] += Math.min(matrix[row + 1][column], Math.min(matrix[row + 1][column - 1], matrix[row + 1][column + 1]));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int value : matrix[0]) {
            result = Math.min(result, value);
        }
        return result;
    }
}
