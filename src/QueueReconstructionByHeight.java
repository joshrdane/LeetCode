import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> result = new LinkedList<>();
        for (int[] person : people)  result.add(person[1], person);
        return result.toArray(new int[people.length][2]);
    }
}
