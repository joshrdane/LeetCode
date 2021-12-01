public class SwapNodesInPairs {
    /**
     * ListNode class provided by LeetCode
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
