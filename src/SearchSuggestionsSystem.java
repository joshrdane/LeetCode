import java.util.*;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product: products) {
            insert(root, product);
        }

        List<List<String>> results = new ArrayList<>();
        for (char c: searchWord.toCharArray()) {
            if ((root = root.children[c - 'a']) == null) break;
            results.add(root.getTopThree());
        }

        while (results.size() < searchWord.length()) {
            results.add(new ArrayList<>());
        }
        return results;
    }

    private void insert(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
            root.addToPQ(word);
        }
    }

    static class TrieNode {
        public TrieNode[] children;
        public PriorityQueue<String> queue;

        public TrieNode() {
            children = new TrieNode[26];
            queue = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addToPQ(String word) {
            queue.add(word);
            if (queue.size() > 3) {
                queue.poll();
            }
        }

        public List<String> getTopThree() {
            List<String> topThree = new ArrayList<>();
            while (!queue.isEmpty()) {
                topThree.add(queue.poll());
            }
            Collections.reverse(topThree);
            return topThree;
        }
    }
}