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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1, l2);

        printList(l1);
        printList(l2);
        printList(l3);
    }

    // Main function (SUBMIT)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int numberOne = l1.val;
        int oneTensCounter = 10;
        int numberTwo = l2.val;
        int twoTensCounter = 10;
        int sum = 0;

        while (l1.next != null) {
            l1 = l1.next;
            numberOne += oneTensCounter * l1.val;
            oneTensCounter *= 10;
        }

        while (l2.next != null) {
            l2 = l2.next;
            numberTwo += twoTensCounter * l2.val;
            twoTensCounter *= 10;
        }

        sum = numberOne + numberTwo;
        return sumToList(sum);
    }

    // Helper method needed for Leetcode solution (SUBMIT)
    public static ListNode sumToList(int sum) {
        ListNode prevNode;
        ListNode initialNode = new ListNode(sum % 10);
        sum = sum / 10;
        prevNode = initialNode;
        while (sum > 0) {
            ListNode newNode = new ListNode(sum % 10);
            prevNode.next = newNode;
            sum = sum / 10;
            prevNode = newNode;
        }
        return initialNode;
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
