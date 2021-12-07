import LC.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {
    public static int getDecimalValue(ListNode node) {
        int result = 0;
        while (node != null) {
            result <<= 1;
            result |= node.val;
            node = node.next;
        }
        return result;
    }
}
