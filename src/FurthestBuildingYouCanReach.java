import java.util.Collections;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] < heights[i+1]) {
                bricks -= heights[i + 1] - heights[i];
                queue.add(heights[i + 1] - heights[i]);
                if (bricks < 0) {
                    bricks += queue.poll();
                    if (ladders > 0) {
                        ladders--;
                    } else {
                        return i;
                    }
                }
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[] {4,2,7,6,9,14,12}, 5, 1));
        System.out.println(furthestBuilding(new int[] {4,12,2,7,3,18,20,3,19}, 10, 2));
        System.out.println(furthestBuilding(new int[] {14,3,19,3}, 17, 0));
        System.out.println(furthestBuilding(new int[] {1,5,1,2,3,4,10000}, 4, 1));
    }
}