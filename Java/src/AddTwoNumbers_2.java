import java.util.List;

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
class AddTwoNumbers_2 {
    public static class ListNode {
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

    public static void main (String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(5);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(5);
//        l2.next.next = new ListNode(3);
//        l2.next.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1, l2);

        printList(l1);
        printList(l2);
        printList(l3);
    }

    // Main function (SUBMIT)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Val = l1.val;
        int l2Val = l2.val;
        int sum = l1Val + l2Val;
        ListNode initial;
        int carryOver = 0;

        if (sum < 10) {
            initial = new ListNode(sum);
        } else {
            initial = new ListNode(sum % 10);
            carryOver = 1;
            if (l1.next == null && l2.next == null) {
                initial.next = new ListNode(1);
                return initial;
            }
        }
        ListNode loopNode = initial;

        while (l1.next != null || l2.next != null) {
            if (l1.next != null) {
                l1 = l1.next;
                l1Val = l1.val;
            } else {
                l1Val = 0;
            }

            if (l2.next != null) {
                l2 = l2.next;
                l2Val = l2.val;
            } else {
                l2Val = 0;
            }

            sum = l1Val + l2Val + carryOver;
            carryOver = 0;
            if (sum < 10) {
                loopNode.next = new ListNode(sum);
            } else {
                loopNode.next = new ListNode(sum % 10);
                carryOver = 1;
            }
            loopNode = loopNode.next;
        }

        if (carryOver == 1) {
            loopNode.next = new ListNode(1);
        }

        return initial;
    }

    // Self created testing helper method
    public static void printList(ListNode listHead) {
        ListNode node = listHead;
        System.out.print(node.val);
        while (node.next != null) {
            node = node.next;
            System.out.print(" -> ");
            System.out.print(node.val);
        }
        System.out.println();
    }

}
