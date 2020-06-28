/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveNthNodeFromEndOfList_19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        ListNode leadingNode = head;
        ListNode removeNode = head;
        ListNode laggingNode = null;

        for (int i = 1; i < n; i++) {
            leadingNode = leadingNode.next;
        }

        while (leadingNode.next != null) {
            if (laggingNode == null) {
                laggingNode = head;
            } else {
                laggingNode = laggingNode.next;
            }
            leadingNode = leadingNode.next;
            removeNode = removeNode.next;
        }

        // Check if last node
        if (removeNode.next == null) {
            laggingNode.next = null;
        } else {
            removeNode.val = removeNode.next.val;
            removeNode.next = removeNode.next.next;
        }

        return head;
    }
}
