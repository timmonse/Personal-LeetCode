public class LinkedListCycle_141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        do {
            try {
                slow = slow.next;
                fast = fast.next.next;
            } catch (Exception e) {
                return false;
            }
        } while (slow != fast);

        return true;
    }
}
