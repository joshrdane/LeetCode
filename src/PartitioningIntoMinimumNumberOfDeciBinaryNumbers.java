public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static int minPartitions(String n) {
        int result = '0';
        for (int i = 0; i < n.length(); i++) {
            result = n.charAt(i) > result ? n.charAt(i) : result;
        }
        return result - '0';
    }
}
