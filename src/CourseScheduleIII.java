import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {
     public static int scheduleCourse(int[][] courses) {
         Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
         PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
         int time = 0;
         for (int[] course : courses)
         {
             time += course[0];
             queue.add(course[0]);
             if (time > course[1] && !queue.isEmpty()) {
                 time -= queue.poll();
             }
         }
         return queue.size();
     }
}
