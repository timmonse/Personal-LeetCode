import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromeLinkedList_234 {
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

    public boolean isPalindrome(ListNode head) {

        ListNode fast = head;

        ListNode prev = null;
        ListNode node = head;
        ListNode next = null;

        while ((fast != null) && (fast.next != null)) {
            fast = fast.next.next;

            next = node.next;
            node.next = prev;
            prev = node;
            node = next;

            //odd
            if (fast != null && fast.next == null) {
                next = next.next;
            }
        }

        while (prev != null && next != null) {
            if (prev.val != next.val) return false;
            prev = prev.next;
            next = next.next;
        }

        return true;
    }
}
