import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int column = 0; column < triangle.get(row).size(); column++) {
                triangle.get(row).set(column, triangle.get(row).get(column) + Math.min(triangle.get(row + 1).get(column), triangle.get(row + 1).get(column + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
