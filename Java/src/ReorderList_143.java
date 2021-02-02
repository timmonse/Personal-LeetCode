import resources.ListNode;

public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode center = findCenter(head);
        ListNode reversed = reverseLinkedList(center);
        joinLists(head, reversed);
    }

    public ListNode findCenter(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = head;

        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slowPrev.next = null;

        return slow;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void joinLists(ListNode one, ListNode two) {

        ListNode saveOne, saveTwo = null;
        ListNode twoOnExit = null;

        while (one != null) {
            saveOne = one.next;
            saveTwo = two.next;
            one.next = two;
            two.next = saveOne;
            twoOnExit = two;
            one = saveOne;
            two = saveTwo;
        }
        if (twoOnExit != null) twoOnExit.next = two;
    }
}
