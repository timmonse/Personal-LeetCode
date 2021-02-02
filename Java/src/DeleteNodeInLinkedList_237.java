import java.util.List;

/**
 * Definition for singly-linked list.
 * public class resources.ListNode {
 * int val;
 * resources.ListNode next;
 * resources.ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeInLinkedList_237 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode initial = new ListNode(4);
        ListNode nodeToDelete = new ListNode(5);
        initial.next = nodeToDelete;
        initial.next.next = new ListNode(1);
        initial.next.next.next = new ListNode(9);
        deleteNode(nodeToDelete);
        printList(initial);
    }

    // !!!This is the function for submission!!!
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void printList(ListNode listHead) {
        ListNode node = listHead;
        System.out.print(node.val);
        while (node.next != null) {
            node = node.next;
            System.out.print(" -> ");
            System.out.print(node.val);
        }
    }
}
