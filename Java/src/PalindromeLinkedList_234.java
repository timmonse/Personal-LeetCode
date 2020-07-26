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
        int count = 0;
        ListNode pointer = head;
        List<Integer> list = new ArrayList<>();

        while (pointer != null) {
            list.add(pointer.val);
            count++;
            pointer = pointer.next;
        }

        count = count / 2;
        list.subList(0, count).clear();
        Collections.reverse(list);
        System.out.println(list.toString());

        for (int num : list) {
            if (num != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
