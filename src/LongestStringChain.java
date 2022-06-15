import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestStringChain {
    public static int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        HashMap<String, Integer> map = new HashMap();

        for (String word : words) {
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String next = sb.deleteCharAt(i).toString();
                if (map.containsKey(next) && map.get(next) + 1 > map.get(word))
                    map.put(word, map.get(next) + 1);
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }
}
