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
class RemoveLinkedListElements {
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

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head;

        if (head == null || (head.next == null && head.val == val)) {
            return null;
        }

        while (node != null && node.next != null) {
            if (node.next.val == val) {
                removeNextNode(node);
            } else {
                node = node.next;
            }
        }

        return head;
    }

    public void removeNextNode(ListNode node) {
        if (node.next.next == null) {
            node.next = null;
            return;
        } else {
            node.next = node.next.next;
            return;
        }
    }
}
