import LC.ListNode;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                ListNode next = head.next;
                head.next = head.next.next;
                next.next = head;
                head = next;

                head.next.next = swapPairs(head.next.next);
            }
        }
        return head;
    }
}
