import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static int minDeletions(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        ConcurrentHashMap<Integer, List<Character>> map = new ConcurrentHashMap<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                List<Character> value;
                if (map.containsKey(count[i])) {
                    value = map.get(count[i]);
                } else {
                    value = new ArrayList<>();
                }
                value.add((char) (i + 'a'));
                map.put(count[i], value);
            }
        }
        int deletions = 0;
        for (Integer i : map.keySet()) {
            while (map.get(i).size() > 1 && i != 0) {
                char c = map.get(i).remove(0);
                int newCount = i;
                do {
                    newCount--;
                    deletions++;
                } while (map.containsKey(newCount) && newCount != 0);
                map.put(newCount, Collections.singletonList(c));
            }
        }
        return deletions;
    }
}
