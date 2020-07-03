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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LinkedListInBinaryTree_1367 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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

    public boolean isSubPath(ListNode head, TreeNode root) {
        return depthFirstSearchFirst(head, root);
    }

    private boolean depthFirstSearchFirst(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            return depthFirstSearchList(head, root) || depthFirstSearchFirst(head, root.right) || depthFirstSearchFirst(head, root.left);
        } else {
            return depthFirstSearchFirst(head, root.right) || depthFirstSearchFirst(head, root.left);
        }
    }

    private boolean depthFirstSearchList(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (head.next == null && head.val == root.val) {
            return true;
        } else if (head.next == null) {
            return false;
        }
        ListNode node;
        if (root.val == head.val) {
            node = head.next;
        } else {
            node = head;
        }

        return depthFirstSearchList(node, root.right) || depthFirstSearchList(node, root.left);
    }
}