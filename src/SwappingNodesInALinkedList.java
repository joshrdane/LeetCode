import LC.ListNode;

public class SwappingNodesInALinkedList {
    public static ListNode swapNodes(ListNode head, int k) {
        int target = depth(head) - 2 * k;
        ListNode front = head;
        while (k > 0) {
            front = front.next;
            k--;
        }
        ListNode back = front;
        while (target > 0) {
            back = back.next;
            target--;
        }
        if (front.val != back.val) {
            front.val ^= back.val;
            back.val ^= front.val;
            front.val ^= back.val;
        }
        return head;
    }

    private static int depth(ListNode node) {
        int i = 0;
        while (node != null) {
            node = node.next;
            i++;
        }
        return i;
    }

    private static int recursiveDepth(ListNode node) {
        if (node.next == null) {
            return 1;
        } else {
            return depth(node.next) + 1;
        }
    }
}
