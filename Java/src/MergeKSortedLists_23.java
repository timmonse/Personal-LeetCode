import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        Queue<Integer> priQ = new PriorityQueue<>();

        for (ListNode ln : lists) {
            ListNode node = ln;
            while (node != null) {
                priQ.add(node.val);
                node = node.next;
            }
        }

        ListNode head, prev, node;
        if (priQ.size() < 1) return null;
        head = new ListNode(priQ.poll());
        node = head;
        prev = head;
        while (priQ.size() > 0) {
            node = new ListNode(priQ.poll());
            prev.next = node;
            prev = node;
        }

        return head;
    }
}
